
package proyecto3_floricela;

import java.awt.HeadlessException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        this.setLocationRelativeTo(null);//Ventana en el centro
        this.setTitle("Empresa Codor Feliz");//Título de ventana
        //Uso del constructor para las tablas de Codornices y Carreras
        jTable_ListadoCodor.setModel(modelo_jtableCodorL);
        modelo_jtableCodorL.addColumn("Nombre");
        modelo_jtableCodorL.addColumn("Edad");
        modelo_jtableCodorL.addColumn("Especie");
        modelo_jtableCodorL.addColumn("Peso");
        modelo_jtableCodorL.addColumn("Núm Identificación");
        modelo_jtableCodorL.addColumn("Dueño");
        jTable_CodorEncontrada.setModel(modelo_jtableCodorB);
        modelo_jtableCodorB.addColumn("Nombre");
        modelo_jtableCodorB.addColumn("Edad");
        modelo_jtableCodorB.addColumn("Especie");
        modelo_jtableCodorB.addColumn("Peso");
        modelo_jtableCodorB.addColumn("Núm Identificación");
        modelo_jtableCodorB.addColumn("Dueño");
        jTable_ListadoCarreras.setModel(modelo_jtableCarrL);
        modelo_jtableCarrL.addColumn("ID Carrera");
        modelo_jtableCarrL.addColumn("Fecha");
        modelo_jtableCarrL.addColumn("Hora");
        modelo_jtableCarrL.addColumn("Codorniz 1");
        modelo_jtableCarrL.addColumn("Tiempo C1");
        modelo_jtableCarrL.addColumn("Codorniz 2");
        modelo_jtableCarrL.addColumn("Tiempo C2");
        modelo_jtableCarrL.addColumn("Codorniz 3");
        modelo_jtableCarrL.addColumn("Tiempo C3");
        modelo_jtableCarrL.addColumn("Codorniz 4");
        modelo_jtableCarrL.addColumn("Tiempo C4");
        modelo_jtableCarrL.addColumn("Codorniz 5");
        modelo_jtableCarrL.addColumn("Tiempo C5");
        jTable_resultadoCarrera.setModel(modelo_jtableCarrB);
        modelo_jtableCarrB.addColumn("ID Carrera");
        modelo_jtableCarrB.addColumn("Fecha");
        modelo_jtableCarrB.addColumn("Hora");
        modelo_jtableCarrB.addColumn("Codorniz 1");
        modelo_jtableCarrB.addColumn("Tiempo C1");
        modelo_jtableCarrB.addColumn("Codorniz 2");
        modelo_jtableCarrB.addColumn("Tiempo C2");
        modelo_jtableCarrB.addColumn("Codorniz 3");
        modelo_jtableCarrB.addColumn("Tiempo C3");
        modelo_jtableCarrB.addColumn("Codorniz 4");
        modelo_jtableCarrB.addColumn("Tiempo C4");
        modelo_jtableCarrB.addColumn("Codorniz 5");
        modelo_jtableCarrB.addColumn("Tiempo C5");
        crear_archivo_codornices();
        crear_archivo_carreras();
//Llamo a la función para leer el archivo y cargar información a las tablas de los listados.
        try {
            leer_archivo(true, "codornices.txt", modelo_jtableCodorL);
            leer_archivo(false, "carreras.txt", modelo_jtableCarrL);
        } catch (IOException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//Declaraciones para Codorniz
    static String nombre;
    static Integer edad;
    static String especie;
    static Double peso;
    static Integer num_id;
    static String nombre_dueño;
    private static DefaultTableModel modelo_jtableCodorB = new DefaultTableModel ();//Tabla buscar
    private static DefaultTableModel modelo_jtableCodorL = new DefaultTableModel ();//Tabla lista
    private static DefaultTableModel modelo_jtableCarrB = new DefaultTableModel ();
    private static DefaultTableModel modelo_jtableCarrL = new DefaultTableModel ();
    //Heredo la clase ArrayList de la interfaz list y creo las listas para guardar los objetos
    static List<Codorniz> codor_list = new ArrayList<>();
    Integer id_buscar;
 //Declaraciones para carreras
    static String ID_carrera;
    static String fecha;
    static String hora;
    static String competidor1;
    static String competidor2;
    static String competidor3;
    static String competidor4;
    static String competidor5;
    static String tiempoCo1;
    static String tiempoCo2;
    static String tiempoCo3;
    static String tiempoCo4;
    static String tiempoCo5;
    //Heredo la clase ArrayList de la interfaz list y creo las listas para guardar los objetos
    List<Carrera> carrera_list = new ArrayList<>();
    
//FUNCIONES
    
/*Función para crear archivo de Codornices*/
    static File archivo_codor; // Creo variable tipo File para poder manipular el archivo
    public void crear_archivo_codornices (){   
        archivo_codor = new File("codornices.txt");//Almaceno en la variable el archivo que voy a crear
        /* Condiciono que si el archivo no existe lo cree*/
            if (!archivo_codor.exists()){
                try {
                    archivo_codor.createNewFile();
                } catch (IOException ERROR){
                    JOptionPane.showMessageDialog(this, "A ocurrido un error inesperado","ERROR",JOptionPane.WARNING_MESSAGE);
                }
            }
    }
    
    /*Función para escribir en el archivo Codornices*/ 
    
    public void escribir_archivo_Codor(Codorniz codorniz) {
        try {
            //Creo objeto FileWriter para escribir en el archivo, con boolean true para que escriba al final del archivo.
            FileWriter escribir_info = new FileWriter(archivo_codor, true);
            escribir_info.write(codorniz.getNombre() + "," + codorniz.getEdad() + "," + codorniz.getEspecie() + "," + codorniz.getPeso() + "," + codorniz.getNum_id() + "," + codorniz.getNombre_dueño() + "\n");
            escribir_info.close();
        } catch (IOException ERROR) {
            JOptionPane.showMessageDialog(this, "A ocurrido un error inesperado", "ERROR", JOptionPane.WARNING_MESSAGE);;
        }
    }
      
/* Función para crear archivo de carreras*/

File archivo_carreras;
    public void crear_archivo_carreras() {
        archivo_carreras = new File("carreras.txt");
        /* Condiciono la creación del archivo*/
        if (!archivo_carreras.exists()) {
            try {
                archivo_carreras.createNewFile();
            } catch (IOException ERROR) {
                JOptionPane.showMessageDialog(this, "A ocurrido un error inesperado", "ERROR", JOptionPane.WARNING_MESSAGE);;
            }
        }
    }
    
/*Función para escribir las carreras en el arhivo*/

public void escribir_archivo_carreras(Carrera carrera){
    try{
            FileWriter escribir_info = new FileWriter(archivo_carreras,true);
            escribir_info.write( carrera.getID_carrera()+ "," + carrera.getFecha() + "," + carrera.getHora() + "," + carrera.getCompetidor1()+ "," +carrera.getTiempoCo1() + "," + carrera.getCompetidor2() + "," + carrera.getTiempoCo2()+ "," + carrera.getCompetidor3() +  "," + carrera.getTiempoCo3() + "," + carrera.getCompetidor4()+ "," + carrera.getTiempoCo4() + "," + carrera.getCompetidor5()+ "," + carrera.getTiempoCo5()+ "\n");
            escribir_info.close();
        }catch(IOException ERROR){
            JOptionPane.showMessageDialog(this, "A ocurrido un error inesperado","ERROR",JOptionPane.WARNING_MESSAGE);;
        }

}

/*Función para leer el archivo y escribir en su tabla respectiva*/

private void leer_archivo( boolean clase_codorniz, String nombre_archivo, DefaultTableModel modelo) throws IOException{

        String fila_archivo[];
        try {
            //Creo objeto FileReader y utilizo Buffer en caso de que el archivo sea temporal
            FileReader archivo = new FileReader(nombre_archivo);
            BufferedReader leer = new BufferedReader(archivo);
            String fila = leer.readLine();
            //Condiciono que mientras la línea que lee no sea nula, la guarde en arreglo sin separador.
            while (fila != null) {
                fila_archivo = fila.split(",");//Con Split separo los atributos.
                modelo.addRow(fila_archivo);//Añado el arreglo al modelo
                if (clase_codorniz) {
                    edad = Integer.parseInt(fila_archivo[1]);
                    num_id = Integer.parseInt(fila_archivo[4]);
                    peso = Double.parseDouble(fila_archivo[3]);
                    Codorniz codorniz = new Codorniz(fila_archivo[0], edad, fila_archivo[2], peso, num_id, fila_archivo[5]);
                    codor_list.add(codorniz);//Añado objeto Codorniz al ArrayList
                } else {//Con este else utilizo la funcion para objeto carrera.
                    Carrera carrera = new Carrera(fila_archivo[0], fila_archivo[1], fila_archivo[2], fila_archivo[3], fila_archivo[4], fila_archivo[5], fila_archivo[6], fila_archivo[7], fila_archivo[8], fila_archivo[9], fila_archivo[10], fila_archivo[11], fila_archivo[12]);
                    carrera_list.add(carrera);

                }
                fila = leer.readLine();//Leo la siguiente línea del archivo mientras esta el ciclo activo.
            }

        } catch (FileNotFoundException ERROR) {
            JOptionPane.showMessageDialog(this, "A ocurrido un error inesperado", "ERROR", JOptionPane.WARNING_MESSAGE);

        }

    }

/*Función para buscar el ID de la Codorniz*/

private void buscar_codorniz(int id_buscar){
        try {
            boolean encontrada = false;//Bandera que permite hacer acciones dependiendo de si se encontró o no el ID.
            int tamano = codor_list.size();//Extraigo el tamaño de ArrayList
            //Recorro el Array List para buscar el ID de los objetos Codorniz
            for (int i = 0; i < tamano; i++) {
                Codorniz leo_objeto = codor_list.get(i);//Utilizo el ArrayList para poder extraer el atributo y guardarlo en variable.
                int id_encontrado = leo_objeto.getNum_id();//Guardo en variable el atributo ID.
                //Si encuentro que un ID coincide extraigo sus atributos y los muestro en la tabla.
                if (id_buscar == id_encontrado) {
                    encontrada = true;//Paso la bandera a verdadera.
                    int age = leo_objeto.getEdad();
                    String edadc = String.valueOf(age);
                    double weight = leo_objeto.getPeso();
                    String pesoc = String.valueOf(weight);
                    int idc = leo_objeto.getNum_id();
                    String numeroid = String.valueOf(idc);
                    String Codor_encontrada[] = {//Guardo en el array los atributos del objeto encontrado.
                        leo_objeto.getNombre(),
                        edadc,
                        leo_objeto.getEspecie(),
                        pesoc,
                        numeroid,
                        leo_objeto.getNombre_dueño()
                    };
                    //Muestro en la tabla el objeto encontrado.
                    modelo_jtableCodorB.addRow(Codor_encontrada);
                }
            }
            if (encontrada == false) {
                JOptionPane.showMessageDialog(this, "La Codorniz que está buscando, no ha sido registrada");
            }
        } catch (Exception ERROR) {
            JOptionPane.showMessageDialog(this, "A ocurrido un error inesperado", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
    }

/*Función para buscar una carrera*/
private void buscar_carrera(int id_buscar){
        try {
            boolean encontrada = false;
            int tamano = carrera_list.size();//Extraigo el tamaño de ArrayList
            //Recorro el Array List para buscar el ID de los objetos Carrera
            for (int i = 0; i < tamano; i++) {
                Carrera leo_objeto = carrera_list.get(i);//Creo una variable tipo carrera y le guardo el atributo
                String encontrado = leo_objeto.getID_carrera(); //Extraigo el ID de la carrera y lo guardo en variable
                int id_encontrado = Integer.parseInt(encontrado);
                //Si encuentro que un ID coincide extraigo sus atributos y los muestro en la tabla.
                if (id_buscar == id_encontrado) {
                    encontrada = true;//Bandera para mandar mensaje.
                    String Carrera_encontrada[]
                            = {
                                leo_objeto.getID_carrera(),
                                leo_objeto.getFecha(),
                                leo_objeto.getHora(),
                                leo_objeto.getCompetidor1(),
                                leo_objeto.getTiempoCo1(),
                                leo_objeto.getCompetidor2(),
                                leo_objeto.getTiempoCo2(),
                                leo_objeto.getCompetidor3(),
                                leo_objeto.getTiempoCo3(),
                                leo_objeto.getCompetidor4(),
                                leo_objeto.getTiempoCo4(),
                                leo_objeto.getCompetidor5(),
                                leo_objeto.getTiempoCo5(),};
                    //Muestro en la tabla el objeto encontrado.
                    modelo_jtableCarrB.addRow(Carrera_encontrada);
                }
            }
            if (encontrada == false) {
                JOptionPane.showMessageDialog(this, "La Carrera que está buscando, no ha sido registrada");
            }
        } catch (Exception ERROR) {
            JOptionPane.showMessageDialog(this, "A ocurrido un error inesperado", "ERROR", JOptionPane.WARNING_MESSAGE);
        }

    }

/*Función para verificar que exista Codorniz*/
private boolean codor_existe ( int id){
    int id_encontrado = 0;
    int tamano = codor_list.size();//Extraigo el tamaño del ArrayLista para recorrerlo.
    for (int i = 0; i < tamano; i++) {
        Codorniz leo_objeto = codor_list.get(i);
        id_encontrado = leo_objeto.getNum_id();
        if (id_encontrado == id) {
            return true;
        }
    }
    return false;
}

/*Función para verificar que la carrera exista*/
private boolean carrera_existe ( int id){
    int id_encontrado = 0;
    int tamano = carrera_list.size();
    for (int i = 0; i < tamano; i++) {
        Carrera leo_objeto = carrera_list.get(i);
        id_encontrado = Integer.parseInt(leo_objeto.getID_carrera());
        if (id_encontrado == id) {
            return true;
        }
    }
    return false;
} 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_header = new javax.swing.JPanel();
        jLabel_bienvenida = new javax.swing.JLabel();
        jLabel_image = new javax.swing.JLabel();
        jTabbed_Main = new javax.swing.JTabbedPane();
        jPanel_RegCodor = new javax.swing.JPanel();
        jLabel_EncabezadoRegistro = new javax.swing.JLabel();
        jLabel_nombreCodor = new javax.swing.JLabel();
        jTextField_NombreCodor = new javax.swing.JTextField();
        jLabel_edadCodor = new javax.swing.JLabel();
        jLabel_especieCodor = new javax.swing.JLabel();
        jLabel_pesoCodor = new javax.swing.JLabel();
        jLabel_numIDCodor = new javax.swing.JLabel();
        jLabel_NomDueño = new javax.swing.JLabel();
        jTextField_edadCodor = new javax.swing.JTextField();
        jTextField_especieCodor = new javax.swing.JTextField();
        jTextField_pesoCodor = new javax.swing.JTextField();
        jTextField_NumIDCodor = new javax.swing.JTextField();
        jTextField_NomDueño = new javax.swing.JTextField();
        jButton_regisCodor = new javax.swing.JButton();
        jLabel_imagen = new javax.swing.JLabel();
        jPanel_Carrera = new javax.swing.JPanel();
        jLabel_RegistroCarrera = new javax.swing.JLabel();
        jLabel_IDCarrera = new javax.swing.JLabel();
        jTextField_IDCarrera = new javax.swing.JTextField();
        jLabel_fechaHora = new javax.swing.JLabel();
        jComboBox_mes = new javax.swing.JComboBox<>();
        jComboBox_dia = new javax.swing.JComboBox<>();
        jComboBox_anio = new javax.swing.JComboBox<>();
        jComboBox_horas = new javax.swing.JComboBox<>();
        jComboBox_minutos = new javax.swing.JComboBox<>();
        jLabel_hour = new javax.swing.JLabel();
        jLabel_2pts = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel_IDcompetidores = new javax.swing.JLabel();
        jLabel_competidor1 = new javax.swing.JLabel();
        jLabel_competidor2 = new javax.swing.JLabel();
        jLabel_competidor3 = new javax.swing.JLabel();
        jLabel_competidor4 = new javax.swing.JLabel();
        jLabel_competidor5 = new javax.swing.JLabel();
        jTextField_IDcompetidor2 = new javax.swing.JTextField();
        jTextField_IDcompetidor1 = new javax.swing.JTextField();
        jTextField_IDcompetidor3 = new javax.swing.JTextField();
        jTextField_IDcompetidor4 = new javax.swing.JTextField();
        jTextField_IDcompetidor5 = new javax.swing.JTextField();
        jButton_RegistrarCarrera = new javax.swing.JButton();
        jLabel_tiempos = new javax.swing.JLabel();
        jLabel_2pts1 = new javax.swing.JLabel();
        jLabel_min = new javax.swing.JLabel();
        jLabel_segundos = new javax.swing.JLabel();
        jComboBox_minC1 = new javax.swing.JComboBox<>();
        jComboBox_segC1 = new javax.swing.JComboBox<>();
        jLabel_2pts2 = new javax.swing.JLabel();
        jLabel_2pts3 = new javax.swing.JLabel();
        jLabel_2pts4 = new javax.swing.JLabel();
        jLabel_2pts5 = new javax.swing.JLabel();
        jComboBox_minC2 = new javax.swing.JComboBox<>();
        jComboBox_minC3 = new javax.swing.JComboBox<>();
        jComboBox_minC4 = new javax.swing.JComboBox<>();
        jComboBox_minC5 = new javax.swing.JComboBox<>();
        jComboBox_segC2 = new javax.swing.JComboBox<>();
        jComboBox_segC3 = new javax.swing.JComboBox<>();
        jComboBox_segC4 = new javax.swing.JComboBox<>();
        jComboBox_segC5 = new javax.swing.JComboBox<>();
        jLabel_IDCodor = new javax.swing.JLabel();
        jPanel_ListCodor = new javax.swing.JPanel();
        jLabel_IndiqueIDC = new javax.swing.JLabel();
        jTextField_IDCodorniz = new javax.swing.JTextField();
        jButton_BuscarCodor = new javax.swing.JButton();
        jLabel_BuscadorCodor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_ListadoCodor = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel_ListadoCodor = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_CodorEncontrada = new javax.swing.JTable();
        jButton_limpiarCodorEncontrada = new javax.swing.JButton();
        jPanel_HistCarreras = new javax.swing.JPanel();
        jLabel_BuscadorCarreras = new javax.swing.JLabel();
        jLabel_Idcarrera = new javax.swing.JLabel();
        jTextField_IDcarrera = new javax.swing.JTextField();
        jButton_BuscadorCarrera = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_ListadoCarreras = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_resultadoCarrera = new javax.swing.JTable();
        jLabel_ListCarreras = new javax.swing.JLabel();
        jButton_limpiarTablaCarreraEncontrada = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel_header.setBackground(new java.awt.Color(164, 68, 23));

        jLabel_bienvenida.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel_bienvenida.setForeground(new java.awt.Color(253, 235, 166));
        jLabel_bienvenida.setText("Bienvenido a Codor_Feliz - Run 1.0");

        jLabel_image.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/codorniz.png"))); // NOI18N

        javax.swing.GroupLayout jPanel_headerLayout = new javax.swing.GroupLayout(jPanel_header);
        jPanel_header.setLayout(jPanel_headerLayout);
        jPanel_headerLayout.setHorizontalGroup(
            jPanel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_headerLayout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jLabel_image)
                .addGap(79, 79, 79)
                .addComponent(jLabel_bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_headerLayout.setVerticalGroup(
            jPanel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_headerLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel_bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_image)
                .addContainerGap())
        );

        jTabbed_Main.setBackground(new java.awt.Color(213, 219, 219));
        jTabbed_Main.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        jPanel_RegCodor.setBackground(new java.awt.Color(76, 83, 112));
        jPanel_RegCodor.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        jLabel_EncabezadoRegistro.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel_EncabezadoRegistro.setForeground(new java.awt.Color(244, 224, 181));
        jLabel_EncabezadoRegistro.setText("Registre a su Codorniz competidora");

        jLabel_nombreCodor.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel_nombreCodor.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_nombreCodor.setText("Nombre:");

        jTextField_NombreCodor.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N

        jLabel_edadCodor.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel_edadCodor.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_edadCodor.setText("Edad en meses:");

        jLabel_especieCodor.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel_especieCodor.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_especieCodor.setText("Especie:");

        jLabel_pesoCodor.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel_pesoCodor.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_pesoCodor.setText("Peso en gramos:");

        jLabel_numIDCodor.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel_numIDCodor.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_numIDCodor.setText("Número de Identificación:");

        jLabel_NomDueño.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel_NomDueño.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NomDueño.setText("Nombre del dueño:");

        jTextField_edadCodor.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jTextField_edadCodor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_edadCodorKeyTyped(evt);
            }
        });

        jTextField_especieCodor.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N

        jTextField_pesoCodor.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jTextField_pesoCodor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_pesoCodorKeyTyped(evt);
            }
        });

        jTextField_NumIDCodor.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jTextField_NumIDCodor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_NumIDCodorKeyTyped(evt);
            }
        });

        jTextField_NomDueño.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N

        jButton_regisCodor.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        jButton_regisCodor.setForeground(new java.awt.Color(201, 59, 49));
        jButton_regisCodor.setText("Registrar Codorniz");
        jButton_regisCodor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_regisCodorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_RegCodorLayout = new javax.swing.GroupLayout(jPanel_RegCodor);
        jPanel_RegCodor.setLayout(jPanel_RegCodorLayout);
        jPanel_RegCodorLayout.setHorizontalGroup(
            jPanel_RegCodorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_RegCodorLayout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(jPanel_RegCodorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_RegCodorLayout.createSequentialGroup()
                        .addGroup(jPanel_RegCodorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_numIDCodor)
                            .addComponent(jLabel_nombreCodor)
                            .addComponent(jLabel_especieCodor))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_RegCodorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_especieCodor, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(jTextField_NombreCodor)
                            .addComponent(jTextField_NumIDCodor))
                        .addGap(109, 109, 109)
                        .addGroup(jPanel_RegCodorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_edadCodor)
                            .addComponent(jLabel_NomDueño)
                            .addComponent(jLabel_pesoCodor)))
                    .addGroup(jPanel_RegCodorLayout.createSequentialGroup()
                        .addComponent(jLabel_EncabezadoRegistro)
                        .addGap(20, 20, 20)))
                .addGroup(jPanel_RegCodorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_NomDueño, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jTextField_pesoCodor)
                    .addComponent(jTextField_edadCodor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_RegCodorLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel_imagen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 348, Short.MAX_VALUE)
                .addComponent(jButton_regisCodor)
                .addGap(389, 389, 389))
        );
        jPanel_RegCodorLayout.setVerticalGroup(
            jPanel_RegCodorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_RegCodorLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel_EncabezadoRegistro)
                .addGap(66, 66, 66)
                .addGroup(jPanel_RegCodorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_pesoCodor)
                    .addComponent(jTextField_pesoCodor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_numIDCodor)
                    .addComponent(jTextField_NumIDCodor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel_RegCodorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_edadCodor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_edadCodor)
                    .addComponent(jLabel_nombreCodor)
                    .addComponent(jTextField_NombreCodor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel_RegCodorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_especieCodor)
                    .addComponent(jLabel_NomDueño)
                    .addComponent(jTextField_especieCodor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_NomDueño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel_RegCodorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_RegCodorLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jButton_regisCodor)
                        .addContainerGap(71, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_RegCodorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_imagen)
                        .addGap(61, 61, 61))))
        );

        jTextField_NumIDCodor.getAccessibleContext().setAccessibleName("");

        jTabbed_Main.addTab("Registro de Codornices", jPanel_RegCodor);

        jPanel_Carrera.setBackground(new java.awt.Color(91, 101, 126));
        jPanel_Carrera.setForeground(new java.awt.Color(255, 255, 255));

        jLabel_RegistroCarrera.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel_RegistroCarrera.setForeground(new java.awt.Color(244, 224, 181));
        jLabel_RegistroCarrera.setText("Registre la carrera");

        jLabel_IDCarrera.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel_IDCarrera.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_IDCarrera.setText("Indique el ID de la carrera");

        jTextField_IDCarrera.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_IDCarreraKeyTyped(evt);
            }
        });

        jLabel_fechaHora.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel_fechaHora.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_fechaHora.setText("Seleccione la fecha y hora");

        jComboBox_mes.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jComboBox_mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre" }));

        jComboBox_dia.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jComboBox_dia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jComboBox_anio.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jComboBox_anio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "3000" }));

        jComboBox_horas.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jComboBox_horas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));

        jComboBox_minutos.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jComboBox_minutos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jLabel_hour.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_hour.setText("Hora");

        jLabel_2pts.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_2pts.setText(":");

        jLabel_IDcompetidores.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel_IDcompetidores.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_IDcompetidores.setText("Coloque el ID de los competidores");

        jLabel_competidor1.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel_competidor1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_competidor1.setText("Competidor 1:");

        jLabel_competidor2.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel_competidor2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_competidor2.setText("Competidor 2:");

        jLabel_competidor3.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel_competidor3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_competidor3.setText("Competidor 3:");

        jLabel_competidor4.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel_competidor4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_competidor4.setText("Competidor 4:");

        jLabel_competidor5.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel_competidor5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_competidor5.setText("Competidor 5:");

        jTextField_IDcompetidor2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_IDcompetidor2KeyTyped(evt);
            }
        });

        jTextField_IDcompetidor1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_IDcompetidor1KeyTyped(evt);
            }
        });

        jTextField_IDcompetidor3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_IDcompetidor3KeyTyped(evt);
            }
        });

        jTextField_IDcompetidor4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_IDcompetidor4KeyTyped(evt);
            }
        });

        jTextField_IDcompetidor5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_IDcompetidor5KeyTyped(evt);
            }
        });

        jButton_RegistrarCarrera.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton_RegistrarCarrera.setForeground(new java.awt.Color(201, 59, 49));
        jButton_RegistrarCarrera.setText("Registrar Carrera");
        jButton_RegistrarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarCarreraActionPerformed(evt);
            }
        });

        jLabel_tiempos.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel_tiempos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_tiempos.setText("Seleccione los tiempos de cada codorniz ");

        jLabel_2pts1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_2pts1.setText(":");

        jLabel_min.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel_min.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_min.setText("Minutos");

        jLabel_segundos.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel_segundos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_segundos.setText("Segundos");

        jComboBox_minC1.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jComboBox_minC1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jComboBox_segC1.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jComboBox_segC1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jLabel_2pts2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_2pts2.setText(":");

        jLabel_2pts3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_2pts3.setText(":");

        jLabel_2pts4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_2pts4.setText(":");

        jLabel_2pts5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_2pts5.setText(":");

        jComboBox_minC2.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jComboBox_minC2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jComboBox_minC3.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jComboBox_minC3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jComboBox_minC4.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jComboBox_minC4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jComboBox_minC5.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jComboBox_minC5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jComboBox_segC2.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jComboBox_segC2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jComboBox_segC3.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jComboBox_segC3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jComboBox_segC4.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jComboBox_segC4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jComboBox_segC5.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jComboBox_segC5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jLabel_IDCodor.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel_IDCodor.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_IDCodor.setText("ID de la Codorniz");

        javax.swing.GroupLayout jPanel_CarreraLayout = new javax.swing.GroupLayout(jPanel_Carrera);
        jPanel_Carrera.setLayout(jPanel_CarreraLayout);
        jPanel_CarreraLayout.setHorizontalGroup(
            jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel_CarreraLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_RegistroCarrera)
                    .addGroup(jPanel_CarreraLayout.createSequentialGroup()
                        .addComponent(jLabel_fechaHora)
                        .addGap(38, 38, 38)
                        .addComponent(jComboBox_dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox_anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_CarreraLayout.createSequentialGroup()
                        .addComponent(jLabel_IDCarrera)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_IDCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_CarreraLayout.createSequentialGroup()
                        .addComponent(jLabel_hour)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_horas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_2pts)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_minutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64))
            .addGroup(jPanel_CarreraLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_CarreraLayout.createSequentialGroup()
                        .addGroup(jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_competidor2)
                            .addComponent(jLabel_competidor1)
                            .addComponent(jLabel_competidor3)
                            .addComponent(jLabel_competidor4)
                            .addComponent(jLabel_competidor5))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField_IDcompetidor2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_IDcompetidor3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_IDcompetidor1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_IDcompetidor4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_IDcompetidor5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_CarreraLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel_IDcompetidores))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_CarreraLayout.createSequentialGroup()
                        .addComponent(jLabel_IDCodor)
                        .addGap(11, 11, 11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_CarreraLayout.createSequentialGroup()
                        .addComponent(jLabel_tiempos)
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_CarreraLayout.createSequentialGroup()
                        .addGroup(jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_CarreraLayout.createSequentialGroup()
                                .addGroup(jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_min)
                                    .addGroup(jPanel_CarreraLayout.createSequentialGroup()
                                        .addComponent(jComboBox_minC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel_2pts1)))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel_CarreraLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jComboBox_segC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel_segundos)))
                            .addGroup(jPanel_CarreraLayout.createSequentialGroup()
                                .addGroup(jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBox_minC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox_minC4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox_minC5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox_minC3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel_CarreraLayout.createSequentialGroup()
                                        .addComponent(jLabel_2pts4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox_segC4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel_CarreraLayout.createSequentialGroup()
                                        .addComponent(jLabel_2pts5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox_segC5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel_CarreraLayout.createSequentialGroup()
                                        .addComponent(jLabel_2pts3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox_segC3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel_CarreraLayout.createSequentialGroup()
                                        .addComponent(jLabel_2pts2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox_segC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(207, 207, 207))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_CarreraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_RegistrarCarrera)
                .addGap(413, 413, 413))
        );
        jPanel_CarreraLayout.setVerticalGroup(
            jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_CarreraLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_IDCarrera)
                    .addComponent(jTextField_IDCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_RegistroCarrera))
                .addGap(28, 28, 28)
                .addGroup(jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_fechaHora)
                    .addComponent(jComboBox_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_horas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_minutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_hour)
                    .addComponent(jLabel_2pts))
                .addGap(23, 23, 23)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_IDcompetidores)
                    .addComponent(jLabel_tiempos))
                .addGap(37, 37, 37)
                .addGroup(jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_CarreraLayout.createSequentialGroup()
                        .addComponent(jLabel_IDCodor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_competidor1)
                            .addComponent(jTextField_IDcompetidor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_competidor2)
                            .addComponent(jTextField_IDcompetidor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_competidor3)
                            .addComponent(jTextField_IDcompetidor3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_competidor4)
                            .addComponent(jTextField_IDcompetidor4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_competidor5)
                            .addComponent(jTextField_IDcompetidor5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_CarreraLayout.createSequentialGroup()
                        .addGroup(jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_min)
                            .addComponent(jLabel_segundos))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_2pts1)
                            .addComponent(jComboBox_segC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_minC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_2pts2)
                            .addComponent(jComboBox_segC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_minC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_2pts3)
                            .addComponent(jComboBox_segC3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_minC3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_2pts4)
                            .addComponent(jComboBox_minC4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_segC4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel_CarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_2pts5)
                            .addComponent(jComboBox_minC5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_segC5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButton_RegistrarCarrera)
                .addGap(26, 26, 26))
        );

        jTabbed_Main.addTab("Registro de Carreras", jPanel_Carrera);

        jPanel_ListCodor.setBackground(new java.awt.Color(91, 101, 126));

        jLabel_IndiqueIDC.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel_IndiqueIDC.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_IndiqueIDC.setText("Indique el ID de la Codorniz:");

        jTextField_IDCodorniz.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jTextField_IDCodorniz.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_IDCodornizKeyTyped(evt);
            }
        });

        jButton_BuscarCodor.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jButton_BuscarCodor.setForeground(new java.awt.Color(201, 59, 49));
        jButton_BuscarCodor.setText("BUSCAR");
        jButton_BuscarCodor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BuscarCodorActionPerformed(evt);
            }
        });

        jLabel_BuscadorCodor.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel_BuscadorCodor.setForeground(new java.awt.Color(244, 224, 181));
        jLabel_BuscadorCodor.setText("Buscador de Codornices");

        jTable_ListadoCodor.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jTable_ListadoCodor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Edad", "Especie", "Peso", "Núm Identificación", "Nombre del Dueño"
            }
        ));
        jScrollPane1.setViewportView(jTable_ListadoCodor);

        jLabel_ListadoCodor.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel_ListadoCodor.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ListadoCodor.setText("Listado de Codornices Incritas");

        jTable_CodorEncontrada.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jTable_CodorEncontrada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Edad", "Especie", "Peso", "Núm Identificación", "Nombre del Dueño"
            }
        ));
        jScrollPane2.setViewportView(jTable_CodorEncontrada);

        jButton_limpiarCodorEncontrada.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jButton_limpiarCodorEncontrada.setForeground(new java.awt.Color(87, 101, 130));
        jButton_limpiarCodorEncontrada.setText("LIMPIAR");
        jButton_limpiarCodorEncontrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_limpiarCodorEncontradaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_ListCodorLayout = new javax.swing.GroupLayout(jPanel_ListCodor);
        jPanel_ListCodor.setLayout(jPanel_ListCodorLayout);
        jPanel_ListCodorLayout.setHorizontalGroup(
            jPanel_ListCodorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel_ListCodorLayout.createSequentialGroup()
                .addGroup(jPanel_ListCodorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_ListCodorLayout.createSequentialGroup()
                        .addGroup(jPanel_ListCodorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_ListCodorLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel_BuscadorCodor)
                                .addGap(82, 82, 82)
                                .addComponent(jLabel_IndiqueIDC)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_IDCodorniz, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(jButton_BuscarCodor)
                                .addGap(41, 41, 41)
                                .addComponent(jButton_limpiarCodorEncontrada))
                            .addGroup(jPanel_ListCodorLayout.createSequentialGroup()
                                .addGap(370, 370, 370)
                                .addComponent(jLabel_ListadoCodor)))
                        .addGap(0, 32, Short.MAX_VALUE))
                    .addGroup(jPanel_ListCodorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel_ListCodorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel_ListCodorLayout.setVerticalGroup(
            jPanel_ListCodorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ListCodorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_ListCodorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_IDCodorniz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_BuscarCodor)
                    .addComponent(jLabel_IndiqueIDC)
                    .addComponent(jLabel_BuscadorCodor)
                    .addComponent(jButton_limpiarCodorEncontrada))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel_ListadoCodor)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbed_Main.addTab("Listado de Codornices", jPanel_ListCodor);

        jPanel_HistCarreras.setBackground(new java.awt.Color(91, 101, 126));

        jLabel_BuscadorCarreras.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel_BuscadorCarreras.setForeground(new java.awt.Color(244, 224, 181));
        jLabel_BuscadorCarreras.setText("Buscador de Carreras");

        jLabel_Idcarrera.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jLabel_Idcarrera.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Idcarrera.setText("Indique el ID de la carrera:");

        jTextField_IDcarrera.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jTextField_IDcarrera.setToolTipText("");
        jTextField_IDcarrera.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_IDcarreraKeyTyped(evt);
            }
        });

        jButton_BuscadorCarrera.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jButton_BuscadorCarrera.setForeground(new java.awt.Color(201, 59, 49));
        jButton_BuscadorCarrera.setText("BUSCAR");
        jButton_BuscadorCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BuscadorCarreraActionPerformed(evt);
            }
        });

        jTable_ListadoCarreras.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jTable_ListadoCarreras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Carrera", "Fecha", "Hora", "ID Codorniz 1", "Tiempo Codorniz 1", "ID Codorniz 2", "Tiempo Codorniz 2", "ID Codorniz 3", "Tiempo Codorniz 3", "ID Codorniz 4", "Tiempo Codorniz 4", "ID Codorniz 5", "Tiempo Codorniz 5"
            }
        ));
        jScrollPane3.setViewportView(jTable_ListadoCarreras);

        jTable_resultadoCarrera.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jTable_resultadoCarrera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Carrera", "Fecha", "Hora", "ID Codorniz 1", "Tiempo Codorniz 1", "ID Codorniz 2", "Tiempo Codorniz 2", "ID Codorniz 3", "Tiempo Codorniz 3", "ID Codorniz 4", "Tiempo Codorniz 4", "ID Codorniz 5", "Tiempo Codorniz 5"
            }
        ));
        jScrollPane4.setViewportView(jTable_resultadoCarrera);

        jLabel_ListCarreras.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel_ListCarreras.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_ListCarreras.setText("Listado de Carreras Realizadas");

        jButton_limpiarTablaCarreraEncontrada.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jButton_limpiarTablaCarreraEncontrada.setForeground(new java.awt.Color(87, 101, 130));
        jButton_limpiarTablaCarreraEncontrada.setText("LIMPIAR");
        jButton_limpiarTablaCarreraEncontrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_limpiarTablaCarreraEncontradaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_HistCarrerasLayout = new javax.swing.GroupLayout(jPanel_HistCarreras);
        jPanel_HistCarreras.setLayout(jPanel_HistCarrerasLayout);
        jPanel_HistCarrerasLayout.setHorizontalGroup(
            jPanel_HistCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel_HistCarrerasLayout.createSequentialGroup()
                .addGroup(jPanel_HistCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_HistCarrerasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(jPanel_HistCarrerasLayout.createSequentialGroup()
                        .addGroup(jPanel_HistCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_HistCarrerasLayout.createSequentialGroup()
                                .addGap(346, 346, 346)
                                .addComponent(jLabel_ListCarreras))
                            .addGroup(jPanel_HistCarrerasLayout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(jLabel_BuscadorCarreras)
                                .addGap(112, 112, 112)
                                .addComponent(jLabel_Idcarrera)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_IDcarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jButton_BuscadorCarrera)
                                .addGap(35, 35, 35)
                                .addComponent(jButton_limpiarTablaCarreraEncontrada)))
                        .addGap(0, 22, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel_HistCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_HistCarrerasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4)
                    .addContainerGap()))
        );
        jPanel_HistCarrerasLayout.setVerticalGroup(
            jPanel_HistCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_HistCarrerasLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel_HistCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_BuscadorCarreras)
                    .addComponent(jLabel_Idcarrera)
                    .addComponent(jTextField_IDcarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_BuscadorCarrera)
                    .addComponent(jButton_limpiarTablaCarreraEncontrada))
                .addGap(117, 117, 117)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_ListCarreras)
                .addGap(25, 25, 25)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel_HistCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_HistCarrerasLayout.createSequentialGroup()
                    .addGap(86, 86, 86)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(343, Short.MAX_VALUE)))
        );

        jTabbed_Main.addTab("Historial de Carreras", jPanel_HistCarreras);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbed_Main)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbed_Main))
        );

        jTabbed_Main.getAccessibleContext().setAccessibleName("Panel_Pestañas");

        pack();
    }// </editor-fold>//GEN-END:initComponents

 /*Funcion para permitir solo valores numericos en las casillas*/
    
public void validar_tecla_num(java.awt.event.KeyEvent evt) {
    int tecla = evt.getKeyChar(); //Guardo la tecla introducida por el usuario
    boolean num = tecla >= 48 && tecla <= 57 || tecla == 8;// Creo boleano que contenga solo caracteres numericos y BS segun ASCII
    if (!num) { //Condiciono que si el boolean es false no guarde la tecla y envio mensaje a pantalla
        evt.consume();//Evito que se guarde lo que el usuario tecleo.
        JOptionPane.showMessageDialog(this, ("Indique solo valores numericos"));
    }
}

/*Función para limpiar las tablas*/

public void limpiar_tabla(DefaultTableModel modelo){
    //utilizo método del modelo para establecer las filas a 0.
    modelo.setRowCount(0);
}

//Funcion para consultar si desea cerrar el programa
public void cerrar_programa() {
        Object[] opciones = {"SI", "NO"}; //Arreglo con las opciones para el usuario.
        int opcion_elegida = JOptionPane.showOptionDialog(rootPane, "Desea cerrar la aplicacion", "Mensaje de Confirmacion",
                JOptionPane.YES_NO_OPTION,//Muestro el pane de las opciones
                JOptionPane.QUESTION_MESSAGE, null, opciones, "SI");//Muestro pane de pregunta al usuario.
        if (opcion_elegida == JOptionPane.YES_OPTION) { //Limito que el programa se cierre solo si el usuario confirma.
            System.exit(0);
        } else {
        }
    }

/* ACCIONES QUE GENERAN LOS BOTONES Y CASILLAS DE LA INTERFAZ*/
    
//Se genera código para las respectivas acciones a realizar cuando se de clic al botón de registrar codorniz.
    private void jButton_regisCodorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_regisCodorActionPerformed

//Extraigo información de las Codornices introducida por usuario 
        try { //Manejo de excepciones en caso de que estén vacías las casillas.
            nombre = jTextField_NombreCodor.getText();
            String edadd = jTextField_edadCodor.getText();
            edad = Integer.parseInt(edadd);
            especie = jTextField_especieCodor.getText();
            String pesoo = jTextField_pesoCodor.getText();
            peso = Double.parseDouble(pesoo);
            String num_idd = jTextField_NumIDCodor.getText();
            num_id = Integer.parseInt(num_idd);
            nombre_dueño = jTextField_NomDueño.getText();
        } catch (Exception ERROR) {
            JOptionPane.showMessageDialog(this, "Por favor llene todos los datos", "No es posible registrar", JOptionPane.WARNING_MESSAGE);
        }

        //Llamado a la función para que verifique que el ID de la Codorniz, no haya sido registrado con anterioridad.
        //Condiciono si la función codor_existe viene en falso -no encontro ID-, para que realice los siguientes pasos.
        if (!codor_existe(num_id)) {
            Codorniz codorniz = new Codorniz(nombre, edad, especie, peso, num_id, nombre_dueño); //Creación del objeto Codorniz
            //Llamo a la función para guardar la información en el archivo
            escribir_archivo_Codor(codorniz);
            JOptionPane.showMessageDialog(this, "Su Codorniz fue registrada con éxito");
            //Llamo función para borrar la informacion de la tabla que se cargó al inicio y evitar que se duplique al cargarla de nuevo en las siguientes líneas. 
            limpiar_tabla(modelo_jtableCodorL);
            codor_list.clear();//Limpio el arraylist
            //Llamo a la función para leer el archivo y cargar información actualizada a la tabla del listado de Codornices.
            try {
                leer_archivo(true, "codornices.txt", modelo_jtableCodorL);
            } catch (IOException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Limpio todos los texfield 
            jTextField_NombreCodor.setText(null);
            jTextField_edadCodor.setText(null);
            jTextField_especieCodor.setText(null);
            jTextField_pesoCodor.setText(null);
            jTextField_NumIDCodor.setText(null);
            jTextField_NomDueño.setText(null);

        } else {
            JOptionPane.showMessageDialog(this, "El ID que intenta registrar ya existe, verifique los registros o cambie el ID", "Atención. El ID debe ser único", JOptionPane.WARNING_MESSAGE);
            //Limpio casilla del ID
            jTextField_NumIDCodor.setText(null);
        }
    }//GEN-LAST:event_jButton_regisCodorActionPerformed

//Se genera código para las respectivas acciones a realizar cuando se de clic al botón de registrar carrera.
    private void jButton_RegistrarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarCarreraActionPerformed
        //Extracción de la información de las carreras
        boolean continuar_accion = true; //Bandera para permitir que se cree y registre la carrera.
        try {
            ID_carrera = jTextField_IDCarrera.getText();
            /*Se extrae el item seleccionado de los ComboBox y se convierten a string,
            posterior se concatenan para almacenarlos en única variable.*/
            String dia = jComboBox_dia.getSelectedItem().toString();
            String mes = jComboBox_mes.getSelectedItem().toString();
            String año = jComboBox_anio.getSelectedItem().toString();
            fecha = (dia + "/" + mes + "/" + año);
            String hour = jComboBox_horas.getSelectedItem().toString();
            String minutos = jComboBox_minutos.getSelectedItem().toString();
            //Lleno la variable concatenando los datos obtenidos por separado
            hora = (hour + ":" + minutos);
            competidor1 = jTextField_IDcompetidor1.getText();
            competidor2 = jTextField_IDcompetidor2.getText();
            competidor3 = jTextField_IDcompetidor3.getText();
            competidor4 = jTextField_IDcompetidor4.getText();
            competidor5 = jTextField_IDcompetidor5.getText();
            String min1 = jComboBox_minC1.getSelectedItem().toString();
            String seg1 = jComboBox_segC1.getSelectedItem().toString();
            tiempoCo1 = (min1 + ":" + seg1);
            String min2 = jComboBox_minC2.getSelectedItem().toString();
            String seg2 = jComboBox_segC2.getSelectedItem().toString();
            tiempoCo2 = (min2 + ":" + seg2);
            String min3 = jComboBox_minC3.getSelectedItem().toString();
            String seg3 = jComboBox_segC3.getSelectedItem().toString();
            tiempoCo3 = (min3 + ":" + seg3);
            String min4 = jComboBox_minC4.getSelectedItem().toString();
            String seg4 = jComboBox_segC4.getSelectedItem().toString();
            tiempoCo4 = (min4 + ":" + seg4);
            String min5 = jComboBox_minC5.getSelectedItem().toString();
            String seg5 = jComboBox_segC5.getSelectedItem().toString();
            tiempoCo5 = (min5 + ":" + seg5);
        } catch (Exception ERROR) {
            JOptionPane.showMessageDialog(this, "A ocurrido un error inesperado, debe brindar toda la información", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        try {
            //Llamado a la función para que verifique que existan las 5 IDs que se desean registrar.

            if (!codor_existe(Integer.parseInt(competidor1))) {
                continuar_accion = false;//No permito la creación ni registro de la carrera con esta bandera en false.
                // Si la codorniz no existe informamos al usuario
                JOptionPane.showMessageDialog(this, "No se encontró la Codorniz, debe registrar primero la Codorniz con el ID: " + competidor1);
            }

            if (!codor_existe(Integer.parseInt(competidor2))) {
                continuar_accion = false;
                // Si la codorniz no existe informamos al usuario
                JOptionPane.showMessageDialog(this, "No se encontró la Codorniz, debe registrar primero la Codorniz con el ID: " + competidor2);
            }

            if (!codor_existe(Integer.parseInt(competidor3))) {
                continuar_accion = false;
                // Si la codorniz no existe informamos al usuario
                JOptionPane.showMessageDialog(this, "No se encontró la Codorniz, debe registrar primero la Codorniz con el ID: " + competidor3);
            }

            if (!codor_existe(Integer.parseInt(competidor4))) {
                continuar_accion = false;
                // Si la codorniz no existe informamos al usuario
                JOptionPane.showMessageDialog(this, "No se encontró la Codorniz, debe registrar primero la Codorniz con el ID: " + competidor4);
            }
            if (!codor_existe(Integer.parseInt(competidor5))) {
                continuar_accion = false;
                // Si la codorniz no existe informamos al usuario
                JOptionPane.showMessageDialog(this, "No se encontró la Codorniz, debe registrar primero la Codorniz con el ID: " + competidor5);
            }

            //Llamar a la funcion para verificar que el ID de carrera no haya sido utilizado con anterioridad.
            //Condiciono si la funcion viene true - porque si encontro el ID- entonces no permito avanzar. 
            if (carrera_existe(Integer.parseInt(ID_carrera))) {
                continuar_accion = false;//No permito el avance para registrar la carrera.
                // Si la carrera ya existe informamos al usuario
                JOptionPane.showMessageDialog(this, "El ID de carrera que intenta registrar " + ID_carrera + " ya ha sido utilizado, por favor coloque otro ID");
                //Limpio el textfiel del ID
                jTextField_IDCarrera.setText(null);
            }
            //Condiciono que si alguna Codorniz no existe o si el ID de carrera ya fue usado que no permita registrar la carrera.
            if (continuar_accion != false) {
                //Creo objeto carrera
                Carrera carrera = new Carrera(ID_carrera, fecha, hora, competidor1, tiempoCo1, competidor2, tiempoCo2, competidor3, tiempoCo3, competidor4, tiempoCo4, competidor5, tiempoCo5);
                //Llamo funcion para escribir en el archivo.
                escribir_archivo_carreras(carrera);
                JOptionPane.showMessageDialog(this, "Su Carrera fue registrada con éxito");
                //Llamo función para que se borren los datos de la tabla ya cargada.
                limpiar_tabla(modelo_jtableCarrL);
                carrera_list.clear();//Limpio el arraylist
                //Llamo a la función que lee el archivo y carga la tabla, para que quede actualizada.
                try {
                    leer_archivo(false, "carreras.txt", modelo_jtableCarrL);
                } catch (IOException ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
                //Limpio todos los texfield yjcombobox
                jTextField_IDCarrera.setText(null);
                jTextField_IDcompetidor1.setText(null);
                jTextField_IDcompetidor2.setText(null);
                jTextField_IDcompetidor3.setText(null);
                jTextField_IDcompetidor4.setText(null);
                jTextField_IDcompetidor5.setText(null);
                jComboBox_horas.setSelectedIndex(0);
                jComboBox_minutos.setSelectedIndex(0);
                jComboBox_dia.setSelectedIndex(0);
                jComboBox_mes.setSelectedIndex(0);
                jComboBox_anio.setSelectedIndex(0);
                jComboBox_minC1.setSelectedIndex(0);
                jComboBox_segC1.setSelectedIndex(0);
                jComboBox_minC2.setSelectedIndex(0);
                jComboBox_segC2.setSelectedIndex(0);
                jComboBox_minC3.setSelectedIndex(0);
                jComboBox_segC3.setSelectedIndex(0);
                jComboBox_minC4.setSelectedIndex(0);
                jComboBox_segC4.setSelectedIndex(0);
                jComboBox_minC5.setSelectedIndex(0);
                jComboBox_segC5.setSelectedIndex(0);

            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this,"Por favor llene todas las casillas","No se puede hacer el registro",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton_RegistrarCarreraActionPerformed

//Se genera código para las acciones respectivas al buscar una Codorniz.
    private void jButton_BuscarCodorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BuscarCodorActionPerformed
        // Código para extraer información del usuario, buscar e imprimir.
        //Extraigo el ID que digita el usuario y lo convierto a entero
        id_buscar = Integer.parseInt(jTextField_IDCodorniz.getText());
        //llamo a la función para buscar si existe la codorniz e imprimir en la tabla
        buscar_codorniz(id_buscar);
    }//GEN-LAST:event_jButton_BuscarCodorActionPerformed

//Se genera código para las acciones respectivas al buscar una Carrera.
    private void jButton_BuscadorCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BuscadorCarreraActionPerformed
        // Código para el botón de buscar carrera
        //Extraigo el ID escrito por el usuario
        id_buscar= Integer.parseInt(jTextField_IDcarrera.getText());
        //Llamado a la función que revisa la lista de Carreras y verifica si existe
        buscar_carrera(id_buscar);
    }//GEN-LAST:event_jButton_BuscadorCarreraActionPerformed

// EVENTOS PARA CASILLAS QUE DEBEN RECIBIR SOLO VALORES NUMERICOS
    
    private void jTextField_NumIDCodorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_NumIDCodorKeyTyped
     //Llamo funcion
     validar_tecla_num(evt);
    }//GEN-LAST:event_jTextField_NumIDCodorKeyTyped

    private void jTextField_pesoCodorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_pesoCodorKeyTyped
        //Llamo funcion
        validar_tecla_num(evt);
    }//GEN-LAST:event_jTextField_pesoCodorKeyTyped

    private void jTextField_edadCodorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_edadCodorKeyTyped
        //Llamo funcion
        validar_tecla_num(evt);
    }//GEN-LAST:event_jTextField_edadCodorKeyTyped

    private void jTextField_IDCarreraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_IDCarreraKeyTyped
        //Llamo funcion
        validar_tecla_num(evt);
    }//GEN-LAST:event_jTextField_IDCarreraKeyTyped

    private void jTextField_IDcompetidor1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_IDcompetidor1KeyTyped
        //Llamo funcion
        validar_tecla_num(evt);
    }//GEN-LAST:event_jTextField_IDcompetidor1KeyTyped

    private void jTextField_IDcompetidor2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_IDcompetidor2KeyTyped
        //Llamo funcion
        validar_tecla_num(evt);
    }//GEN-LAST:event_jTextField_IDcompetidor2KeyTyped

    private void jTextField_IDcompetidor3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_IDcompetidor3KeyTyped
        //Llamo funcion
        validar_tecla_num(evt);
    }//GEN-LAST:event_jTextField_IDcompetidor3KeyTyped

    private void jTextField_IDcompetidor4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_IDcompetidor4KeyTyped
        //Llamo funcion
        validar_tecla_num(evt);
    }//GEN-LAST:event_jTextField_IDcompetidor4KeyTyped

    private void jTextField_IDcompetidor5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_IDcompetidor5KeyTyped
        //Llamo funcion
        validar_tecla_num(evt);
    }//GEN-LAST:event_jTextField_IDcompetidor5KeyTyped

    private void jTextField_IDCodornizKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_IDCodornizKeyTyped
        //Llamo funcion
        validar_tecla_num(evt);
    }//GEN-LAST:event_jTextField_IDCodornizKeyTyped

    private void jTextField_IDcarreraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_IDcarreraKeyTyped
        //Llamo funcion
        validar_tecla_num(evt);
    }//GEN-LAST:event_jTextField_IDcarreraKeyTyped

//EVENTOS PARA OTROS BOTONES ESPECÍFICOS
    
    private void jButton_limpiarCodorEncontradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_limpiarCodorEncontradaActionPerformed
        // Llamo a la funcion para que limpie la tabla cuando el usuario utilice el botón.
        limpiar_tabla(modelo_jtableCodorB);
        //Limpio el texfield 
        jTextField_IDCodorniz.setText(null);
    }//GEN-LAST:event_jButton_limpiarCodorEncontradaActionPerformed

    private void jButton_limpiarTablaCarreraEncontradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_limpiarTablaCarreraEncontradaActionPerformed
        //  Llamo a la funcion para que limpie la tabla cuando el usuario utilice el botón.
        limpiar_tabla(modelo_jtableCarrB);
        //Limpio el texfield 
        jTextField_IDcarrera.setText(null);
    }//GEN-LAST:event_jButton_limpiarTablaCarreraEncontradaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //Llamo a la función para consultar si desea cerrar, si usuario indica que si el programa se cierra.
        cerrar_programa();
    }//GEN-LAST:event_formWindowClosing

    

    public static void main(String args[]) {
    
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_BuscadorCarrera;
    private javax.swing.JButton jButton_BuscarCodor;
    private javax.swing.JButton jButton_RegistrarCarrera;
    private javax.swing.JButton jButton_limpiarCodorEncontrada;
    private javax.swing.JButton jButton_limpiarTablaCarreraEncontrada;
    private javax.swing.JButton jButton_regisCodor;
    private javax.swing.JComboBox<String> jComboBox_anio;
    private javax.swing.JComboBox<String> jComboBox_dia;
    private javax.swing.JComboBox<String> jComboBox_horas;
    private javax.swing.JComboBox<String> jComboBox_mes;
    private javax.swing.JComboBox<String> jComboBox_minC1;
    private javax.swing.JComboBox<String> jComboBox_minC2;
    private javax.swing.JComboBox<String> jComboBox_minC3;
    private javax.swing.JComboBox<String> jComboBox_minC4;
    private javax.swing.JComboBox<String> jComboBox_minC5;
    private javax.swing.JComboBox<String> jComboBox_minutos;
    private javax.swing.JComboBox<String> jComboBox_segC1;
    private javax.swing.JComboBox<String> jComboBox_segC2;
    private javax.swing.JComboBox<String> jComboBox_segC3;
    private javax.swing.JComboBox<String> jComboBox_segC4;
    private javax.swing.JComboBox<String> jComboBox_segC5;
    private javax.swing.JLabel jLabel_2pts;
    private javax.swing.JLabel jLabel_2pts1;
    private javax.swing.JLabel jLabel_2pts2;
    private javax.swing.JLabel jLabel_2pts3;
    private javax.swing.JLabel jLabel_2pts4;
    private javax.swing.JLabel jLabel_2pts5;
    private javax.swing.JLabel jLabel_BuscadorCarreras;
    private javax.swing.JLabel jLabel_BuscadorCodor;
    private javax.swing.JLabel jLabel_EncabezadoRegistro;
    private javax.swing.JLabel jLabel_IDCarrera;
    private javax.swing.JLabel jLabel_IDCodor;
    private javax.swing.JLabel jLabel_IDcompetidores;
    private javax.swing.JLabel jLabel_Idcarrera;
    private javax.swing.JLabel jLabel_IndiqueIDC;
    private javax.swing.JLabel jLabel_ListCarreras;
    private javax.swing.JLabel jLabel_ListadoCodor;
    private javax.swing.JLabel jLabel_NomDueño;
    private javax.swing.JLabel jLabel_RegistroCarrera;
    private javax.swing.JLabel jLabel_bienvenida;
    private javax.swing.JLabel jLabel_competidor1;
    private javax.swing.JLabel jLabel_competidor2;
    private javax.swing.JLabel jLabel_competidor3;
    private javax.swing.JLabel jLabel_competidor4;
    private javax.swing.JLabel jLabel_competidor5;
    private javax.swing.JLabel jLabel_edadCodor;
    private javax.swing.JLabel jLabel_especieCodor;
    private javax.swing.JLabel jLabel_fechaHora;
    private javax.swing.JLabel jLabel_hour;
    private javax.swing.JLabel jLabel_image;
    private javax.swing.JLabel jLabel_imagen;
    private javax.swing.JLabel jLabel_min;
    private javax.swing.JLabel jLabel_nombreCodor;
    private javax.swing.JLabel jLabel_numIDCodor;
    private javax.swing.JLabel jLabel_pesoCodor;
    private javax.swing.JLabel jLabel_segundos;
    private javax.swing.JLabel jLabel_tiempos;
    private javax.swing.JPanel jPanel_Carrera;
    private javax.swing.JPanel jPanel_HistCarreras;
    private javax.swing.JPanel jPanel_ListCodor;
    private javax.swing.JPanel jPanel_RegCodor;
    private javax.swing.JPanel jPanel_header;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbed_Main;
    private javax.swing.JTable jTable_CodorEncontrada;
    private javax.swing.JTable jTable_ListadoCarreras;
    private javax.swing.JTable jTable_ListadoCodor;
    private javax.swing.JTable jTable_resultadoCarrera;
    private javax.swing.JTextField jTextField_IDCarrera;
    private javax.swing.JTextField jTextField_IDCodorniz;
    private javax.swing.JTextField jTextField_IDcarrera;
    private javax.swing.JTextField jTextField_IDcompetidor1;
    private javax.swing.JTextField jTextField_IDcompetidor2;
    private javax.swing.JTextField jTextField_IDcompetidor3;
    private javax.swing.JTextField jTextField_IDcompetidor4;
    private javax.swing.JTextField jTextField_IDcompetidor5;
    private javax.swing.JTextField jTextField_NomDueño;
    private javax.swing.JTextField jTextField_NombreCodor;
    private javax.swing.JTextField jTextField_NumIDCodor;
    private javax.swing.JTextField jTextField_edadCodor;
    private javax.swing.JTextField jTextField_especieCodor;
    private javax.swing.JTextField jTextField_pesoCodor;
    // End of variables declaration//GEN-END:variables
}
