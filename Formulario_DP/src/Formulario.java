import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Formulario extends JFrame implements ActionListener, ChangeListener, ItemListener {

    //Creamos las variables y los objetos que usaremos
    private JLabel label [] = new JLabel[17];
    int numlabel = 17;
    String textolabel[] = {"FORMULARIO DE DATOS PERSONALES","Datos de contacto","Datos Guardados","Nombre*","Apellidos*",
            "Dirección*","Teléfono","NIF","CP","Email","Contraseña","Pais","Provincia","Población*","Sexo*",
            "Idiomas*","Carta de presentacion*"};
    int xlabel[] = {350,50,750,75,250,75,340,75,250,75,350,75,250,450,75,75,75};
    int ylabel[] = {10,50,50,100,100,150,150,200,200,250,250,300,300,300,350,390,430};
    int ancholabel[] = {550,200,200,55,75,75,90,50,50,50,75,75,75,75,50,75,200};
    int altolabel = 50;
    private JTextField field [] = new JTextField[10];
    int xfield[] = {135,315,140,430,110,285,125,430,525,640};
    int yfield[] = {110,110,160,160,210,210,260,260,310,370};
    int anchofield[] = {100,200,160,100,100,50,200,100,100,100};
    int altofield = 30;
    int numfield = 10;
    private JTextArea tacarta;
    private JComboBox jcpais,jcprovincia;
    String paises[] = {"","España","Reino Unido","Francia","Alemania","Italia","Rusia","Portugal","Esatdos Unidos","Noruega","Dinamarca"};
    String provinciasE [] = {"","Madrid","Valecia","Cuenca","Barcelona","Toledo","Ciudad Real","Segovia","Alicante","Murcia","Asturias"};
    String provinciasI [] = {"","Inglaterra", "Escocia", "Gales","Irlanda del Norte"};
    String provinciasF [] = {"","Gran Este","Nueva Aquitania","Bretaña","Alta Francia","País del Loira","Nueva Aquitania"};
    String provinciasA [] = {"","Berlín","Brandeburgo","Hamburgo","Baja Sajonia","Renania-Palatinado","Schleswig-Holstein"};
    String provinciasIT [] = {"","Abruzos","Cerdeña","Lombardía","Sicilia","Véneto","Toscana","Piamonte"};
    String provinciasR [] = {"","Cáucaso Norte","Centro","Chernozem Central","Lejano Oriente","Kaliningrado","Norte","Noroeste","Siberia del Este"};
    String provinciasP [] = {"","Norte","Centro","Lisboa","Alentejo","Algarve"};
    String provinciasEU [] = {"","Nueva Inglaterra","Atlántico Norte","Centro Noreste","","Centro Noroeste","Atlántico Sur","Centro Sureste","Centro Suroeste","Montañas","Pacífico"};
    String provinciasN [] = {"","Svalbard","Sørlandet","Østlandet","Vestlandet","Trøndelag","Nord-Norge"};
    String provinciasD [] = {"","Región Capital","Jutlandia Central","Dinamarca Meridional","Selandia","Jutlandia Septentrional"};
    private JRadioButton radiob [] = new JRadioButton[3];
    int numradiob = 3;
    String textosexo [] = {"Hombre","Mujer","Otros"};
    int xsexo[] = {125,225,325};
    private ButtonGroup grupobotones;
    private JCheckBox checb [] = new JCheckBox[6];
    int numchecb = 6;
    String textochecb[] = {"Español","Inglés","Francés","Alemán","Italiano","Otros"};
    int xcheck[] = {150,250,340,440,540,640};
    int anchocheck = 75;
    private JButton jbgenerar;
    private JScrollPane jscarta,jsdatos;
    private JEditorPane jedatos;
    private JMenuBar menuBar;
    private JMenu menu[] = new JMenu[5];
    int nummenu = 5;
    String textojmenu [] = {"Menú de opciones","Formato","Acciones","Color","Tamaño"};
    private JMenuItem items[] = new JMenuItem[12];
    int numitem = 12;
    String textoitem [] = {"Rojo","Azul","Verde","Amarillo","Negro","1","2","3","4(original)","5"};
    String sexo = "", idiomae="", idiomai="", idiomaf="", idiomaa="", idiomait="", idiomasotros="", texto="";
    String color;
    int tamaño = 4;
    String dni;
    int resto;
    String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
    char letra;
    boolean malnad,malt,malnif,malcp,malp,mals,mali,malc = false;
    private JTextField direccion;
    private JLabel textodireccion;
    String nombre = "";
    public static JFileChooser buscador;
    private File archivo;
    private JLabel imagen;
    int seleccion;
    private FileNameExtensionFilter filtro;

    //Creamos los metodos que se ejecutaran las ejecutar el método principal "Formulario"
    Formulario(){
        initexto();
        initboton();
        botonim();
        initmenu();
        repaint();
        initventana();
    }

    //Método que crea y ajusta el menú
    private void initmenu() {
        //Creamos el JMenuBar y lo asociamos con el JFrame
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        //Bucle que me iguala cada posicion del array menu como un JMenu
        for (int i = 0; i < nummenu; i++){
            menu[i] = new JMenu(textojmenu[i]);
        }

        //Creamos el primer JMenu y lo hacemos el menu principal
        menuBar.add(menu[0]);

        //Creamos el menú formato(lo añadinos al menú principal)  con sus respectivos menus y items
        menu[0].add(menu[1]);
        //Menu de Color
        menu[1].add(menu[3]);
        for (int i = 0; i < numitem-7;i++){
            items[i] = new JMenuItem(textoitem[i]);
            items[i].addActionListener(this);
            menu[3].add(items[i]);
        }
        //Menu de Fuente
        menu[1].add(menu[4]);
        for (int i = 5; i < numitem-2;i++){
            items[i] = new JMenuItem(textoitem[i]);
            items[i].addActionListener(this);
            menu[4].add(items[i]);
        }
        //Creamos el menú Acciones(lo añadimos al menú principal) con sus items
        menu[0].add(menu[2]);
        items[10] = new JMenuItem("Limpiar todos los campos");
        menu[2].add(items[10]);
        items[10].addActionListener(this);
        items[11] = new JMenuItem("Salir de la aplicaion");
        menu[2].add(items[11]);
        items[11].addActionListener(this);
    }

    //Método que escribe y coloca los objetos en la ventana
    private void initexto() {

        //Bucle que crea JLabels, coloca y añade a la ventana
        for (int i = 0; i< numlabel; i++){
            label[i] = new JLabel(textolabel[i]);
            label[i].setBounds(xlabel[i],ylabel[i],ancholabel[i],altolabel);
            add(label[i]);
        }

        //Cambiamos la fuente de algunos labels
        label[0].setFont(new Font("Cinzel Black",Font.PLAIN,25));
        //Datos personales
        label[1].setFont(new Font("Cinzel Black",Font.PLAIN,15));
        //Info guardada
        label[2].setFont(new Font("Cinzel Black",Font.PLAIN,15));

        //Bucle que crea JTextField, coloca y añade a la ventana
        for (int i = 0; i < numfield; i++){
            field[i] = new JTextField();
            field[i].setBounds(xfield[i],yfield[i],anchofield[i],altofield);
            add(field[i]);
        }

        //Hacemos que el field de telefono y codigo postal solo admitan numeros
        field[3].addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char letra = e.getKeyChar();
                if (((letra < '0') || (letra > '9')) && (letra != '\b')){
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        field[5].addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char letra = e.getKeyChar();
                if (((letra < '0') || (letra > '9')) && (letra != '\b')){
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        //Dejamos el field 9 (idiomas otros)invisible
        field[9].setVisible(false);

        //Bucle que me iguala cada posicion del array cbox como un checbox
        for (int i = 0; i < numchecb; i++){
            checb[i] = new JCheckBox(textochecb[i]);
            int ancho = (i == 3) ? 85 : anchocheck;
            checb[i].setBounds(xcheck[i],400,ancho,30);
            checb[i].addChangeListener(this);
            add(checb[i]);
        }

        //Bucle que me crea el JComboBox, me coloca, me añade a la ventana y me crea los items
        jcpais = new JComboBox();
        jcpais.setBounds(125,310,100,30);
        add(jcpais);
        for (int i = 0; i < 11;i++){
            jcpais.addItem(paises[i]);
            jcpais.addItemListener(this);
        }

        //Provicia
        jcprovincia = new JComboBox();
        jcprovincia.setBounds(325,310,100,30);
        add(jcprovincia);
        jcprovincia.addItem("");

        //Bucle que crea obejtos JRadioButton, coloca y añade en la ventana
        grupobotones = new ButtonGroup();
        for (int i = 0; i < numradiob; i++){
            radiob[i] = new JRadioButton(textosexo[i]);
            radiob[i].setBounds(xsexo[i],363,100,25);
            add(radiob[i]);
            radiob[i].addActionListener(this);
        }

        //Carta de presentacion
        tacarta = new JTextArea();
        tacarta.setLineWrap(true);
        jscarta = new JScrollPane(tacarta);
        jscarta.setBounds(75,475,400,200);
        add(jscarta);

        //LABEL de la foto
        imagen = new JLabel();
        imagen.setBounds(760,125,150,150);
        imagen.setVisible(false);
        add(imagen);

        //Datos guardados
        jedatos = new JEditorPane();
        jedatos.setContentType("text/html");
        jedatos.setEditable(false);
        jsdatos = new JScrollPane(jedatos);
        jsdatos.setBounds(750,100,400,580);
        add(jsdatos);

        //Añado los objetos de subir imagen
        textodireccion = new JLabel("Direccion de la imagen");
        direccion = new JTextField();
        direccion.setBounds(540,475,150,30);
        textodireccion.setBounds(545,445,200,30);
        add(direccion);
        add(textodireccion);
        direccion.setVisible(false);
        textodireccion.setVisible(false);

    }

    //Método que realiza una accion al pulsar un item u objeto
    @Override
    public void actionPerformed(ActionEvent e) {
        //Accion del menú de Acciones
        int j = 0;
        //Cuando pulsamos algun item del menú..
        while (j < numitem){
            if (e.getSource()==items[j]){
                switch (j){
                    //Accion del menú de Formato Color
                    case 0:
                        color = "red";
                        jedatos.setText(
                                "<font size ='" + tamaño + "' color ='" + color + "'>" + texto + "</font>"
                        );
                        break;
                    case 1:
                        color = "blue";
                        jedatos.setText(
                                "<font size ='" + tamaño + "' color ='" + color + "'>" + texto + "</font>"
                        );
                        break;
                    case 2:
                        color = "green";
                        jedatos.setText(
                                "<font size ='" + tamaño + "' color ='" + color + "'>" + texto + "</font>"
                        );
                        break;
                    case 3:
                        color = "yellow";
                        jedatos.setText(
                                "<font size ='" + tamaño + "' color ='" + color + "'>" + texto + "</font>"
                        );
                        break;
                    case 4:
                        color = "black";
                        jedatos.setText(
                                "<font size ='" + tamaño + "' color ='" + color + "'>" + texto + "</font>"
                        );
                        break;
                    //Accion del menú de Formato Fuente
                    case 5:
                        tamaño = 1;
                        jedatos.setText(
                                "<font size ='" + tamaño + "' color ='" + color + "'>" + texto + "</font>"
                        );
                        break;
                    case 6:
                        tamaño = 2;
                        jedatos.setText(
                                "<font size ='" + tamaño + "' color ='" + color + "'>" + texto + "</font>"
                        );
                        break;
                    case 7:
                        tamaño = 3;
                        jedatos.setText(
                                "<font size ='" + tamaño + "' color ='" + color + "'>" + texto + "</font>"
                        );
                        break;
                    case 8:
                        tamaño = 4;
                        jedatos.setText(
                                "<font size ='" + tamaño + "' color ='" + color + "'>" + texto + "</font>"
                        );
                        break;
                    case 9:
                        tamaño = 5;
                        jedatos.setText(
                                "<font size ='" + tamaño + "' color ='" + color + "'>" + texto + "</font>"
                        );
                        break;
                    //Limpiar todos los campos
                    case 10:
                        //limpiamos los labels
                        for (int i = 0; i < numlabel; i++){
                            label[i].setForeground(Color.BLACK);
                        }
                        //limpiamos los fields
                        for (int i = 0; i< numfield;i++){
                            field[i].setText("");
                        }
                        //limpiamos los checbox
                        for (int i = 0; i < checb.length; i++){
                            checb[i].setSelected(false);
                        }
                        //limpiamos los radiobuttons
                        for (int i = 0; i < numradiob;i++){
                            radiob[i].setSelected(false);
                        }
                        //limpiamos las variables y los objetos dejandolos en su valor por efecto
                        field[9].setVisible(false);
                        direccion.setVisible(false);
                        textodireccion.setVisible(false);
                        imagen.setVisible(false);
                        malnad = false;
                        malt = false;
                        malnif = false;
                        malcp = false;
                        malp = false;
                        mals = false;
                        mali = false;
                        malc = false;
                        archivo = new File("");
                        imagen.setText("");
                        seleccion = 0;
                        buscador = new JFileChooser();
                        label[6].setText("Teléfono");
                        tacarta.setText("");
                        jedatos.setText("");
                        direccion.setText("");
                        jcpais.setSelectedItem("");
                        jcprovincia.setSelectedItem("");
                        tamaño = 4;
                        sexo = "";
                        idiomae = "";
                        idiomai = "";
                        idiomaf = "";
                        idiomaa = "";
                        idiomait = "";
                        idiomasotros = "";
                        nombre = "";
                        break;
                    //Salir de la aplicacion
                    case 11:
                        System.exit(0);
                }
            }
            j++;
        }

        //Si pulsamos x radio buton....
        if (radiob[0].isSelected()){
            sexo = "Hombre";
        }
        else if (radiob[1].isSelected()){
            sexo = "Mujer";
        }
        else if (radiob[2].isSelected()){
            sexo = "Otros";
        }
    }

    //Método que cambia el estado de las varibales al seleccioanr un objeto
    @Override
    public void stateChanged(ChangeEvent e) {
        //
        for (int i = 0; i < numchecb;i++){
            if (checb[i].isSelected()){
                switch (i){
                    case 0: idiomae = "Español, ";
                        break;
                    case 1: idiomai = "Inglés, ";
                        break;
                    case 2: idiomaf = "Francés, ";
                        break;
                    case 3: idiomaa = "Alemán, ";
                        break;
                    case 4: idiomait = "Italiano, ";
                        break;
                    case 5:
                        field[9].setVisible(true);
                        break;
                }
            } else field[9].setVisible(false);//hacemos invisible el field de otros
        }
    }

    //Método que modifica el label telefono y (elimina antes) añade items(provincias) a los combobox
    @Override
    public void itemStateChanged(ItemEvent e) {
        for (int i = 0; i < paises.length; i++) {
            if (e.getSource().equals(jcpais)) {
                if (jcpais.getSelectedItem().equals(paises[i])) {
                    switch (i) {
                        case 1: //ESPAÑA
                            label[6].setText("Teléfono  +34");
                            jcprovincia.removeAllItems();
                            for (int j = 0; j < provinciasE.length;j++){
                                 jcprovincia.addItem(provinciasE[j]);
                            }
                            break;
                        case 2: //REINO UNIDO
                            label[6].setText("Teléfono  +44");
                            jcprovincia.removeAllItems();
                            for (int j = 0; j < provinciasI.length;j++){
                                jcprovincia.addItem(provinciasI[j]);
                            }
                            break;
                        case 3://FRANCIA
                            label[6].setText("Teléfono  +33");
                            jcprovincia.removeAllItems();
                            for (int j = 0; j < provinciasF.length;j++){
                                jcprovincia.addItem(provinciasF[j]);
                            }
                            break;
                        case 4://ALEMANIA
                            label[6].setText("Teléfono  +49");
                            jcprovincia.removeAllItems();
                            for (int j = 0; j < provinciasA.length;j++){
                                jcprovincia.addItem(provinciasA[j]);
                            }
                            break;
                        case 5://ITALIA
                            label[6].setText("Teléfono  +39");
                            jcprovincia.removeAllItems();
                            for (int j = 0; j < provinciasIT.length;j++){
                                jcprovincia.addItem(provinciasIT[j]);
                            }
                            break;
                        case 6://RUSIA
                            label[6].setText("Teléfono  +7");
                            jcprovincia.removeAllItems();
                            for (int j = 0; j < provinciasR.length;j++){
                                jcprovincia.addItem(provinciasR[j]);
                            }
                            break;
                        case 7://PORTUGAL
                            label[6].setText("Teléfono  +351");
                            jcprovincia.removeAllItems();
                            for (int j = 0; j < provinciasP.length;j++){
                                jcprovincia.addItem(provinciasP[j]);
                            }
                            break;
                        case 8://ESTADOS UNIDOS
                            label[6].setText("Teléfono  +1");
                            jcprovincia.removeAllItems();
                            for (int j = 0; j < provinciasEU.length;j++){
                                jcprovincia.addItem(provinciasEU[j]);
                            }
                            break;
                        case 9://NORUEGA
                            label[6].setText("Teléfono  +47");
                            jcprovincia.removeAllItems();
                            for (int j = 0; j < provinciasN.length;j++){
                                jcprovincia.addItem(provinciasN[j]);
                            }
                            break;
                        case 10://DINAMARCA
                            label[6].setText("Teléfono  +45");
                            jcprovincia.removeAllItems();
                            for (int j = 0; j < provinciasD.length;j++){
                                jcprovincia.addItem(provinciasD[j]);
                            }
                            break;
                    }
                }
            }
        }
    }

    //Método que comprueba que los los fields sean válidos y escribe en el Editor Panel
    private void initboton() {
        //Boton de generar datos
        jbgenerar = new JButton("Generar Datos");
        jbgenerar.setBounds(540,600,150,50);
        add(jbgenerar);
        //Creamos la accion de pulsar el boton de generar datos
        jbgenerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto = "";
                int i = 0;
                int j = 3;
                tamaño = 4;
                //VALIDACION CAMPOS
                while (i < numlabel) {
                    switch (i){
                        //Nombre, Apellidos y direccion llevan la misma validacion
                        case 0://NOMBRE
                        case 1://APELLIDOS
                        case 2://DIRECCION
                            if (field[i].getText().equals("")) {//si el campo está cacio...
                                texto += "El campo " + textolabel[j] + " no debe estar vacio<br>";
                                label[j].setForeground(Color.red);
                            }else {
                                label[j].setForeground(Color.black);
                                malnad = true;
                            }
                            break;
                        case 3://TELEFONO
                            if (field[i].getText().length() < 9) {//si el campo es menor a 9...
                                texto += "El campo " + textolabel[j] + " debe contener al menos 9 números<br>";
                                label[j].setForeground(Color.red);
                            }else {
                                label[j].setForeground(Color.black);
                                malt = true;
                            }
                            break;
                        case 4://NIF
                            if (field[i].getText().equals("")){//si el campo está ...
                                texto += "El campo " + textolabel[j] + " no es valido<br>";
                                label[j].setForeground(Color.red);
                            }else {
                                if (field[i].getText().length()!=9) {//si el campo no tiene 9 digitios...
                                    texto += "El campo " + textolabel[j] + " tiene que tener 8 numeros y 1 letra<br>";
                                    label[j].setForeground(Color.orange);
                                }else {
                                    int l = field[i].getText().length() - 1;
                                    dni = field[i].getText().substring(0, l);
                                    char ultima = field[i].getText().charAt(field[i].getText().length() - 1);
                                    if (!dni.matches("[0-9]*")){//si los 8 primeros digitos no son nuemeros...
                                        texto += "Las primeras 8 cifras del campo " + textolabel[j] + " tienen que ser numeros y la ultima una letra<br>";
                                        label[j].setForeground(Color.orange);
                                    }else {
                                        resto = Integer.parseInt(dni) % 23;
                                        letra = letras.charAt(resto);
                                        if (letra == ultima) {//si la ultima letra con la variable no son iguales...
                                            label[j].setForeground(Color.BLACK);
                                            malnif = true;
                                        }else {
                                            texto += "El NIF introducido no existe<br>";
                                            label[j].setForeground(Color.orange);
                                        }
                                    }
                                }
                            }
                            break;
                        case 5://CP
                            if (field[i].getText().length() != 5) {
                                texto += "El campo " + textolabel[j] + " solo deebe contener 5 digitos<br>";
                                label[j].setForeground(Color.red);
                            }else {
                                label[j].setForeground(Color.black);
                                malcp = true;
                            }
                            break;
                        case 8://POBLACION
                            if (field[i].getText().equals("")) {
                                texto += "El campo " + textolabel[j + 2] + " no debe estar vacio<br>";
                                label[j+2].setForeground(Color.red);
                            }else {
                                label[j+2].setForeground(Color.black);
                                malp = true;
                            }
                            break;
                    }
                    i++;
                    j++;
                }
                //SEXO
                if (sexo == "") {
                    texto += "EL campo " + textolabel[14] + " tiene que tener uno seleccionado<br>";
                    label[14].setForeground(Color.red);
                }else {
                    label[14].setForeground(Color.black);
                    mals = true;
                }
                //IDIOMAS
                if (idiomait == "" && idiomai == "" && idiomaa == "" && idiomae == "" && idiomaf == "" && idiomasotros == "") {
                    texto += "El campo " + textolabel[15] + " tiene que tener al menos uno seleccionado<br>";
                    label[15].setForeground(Color.red);
                }else {
                    label[15].setForeground(Color.black);
                    mali = true;
                }
                //CARTA DE PRESENTACIÓN
                if (tacarta.getText().equals("")) {
                    texto += "El campo " + textolabel[16] + " no debe estar vacio";
                    label[16].setForeground(Color.red);
                }
                else{
                    label[16].setForeground(Color.black);
                    malc = true;
                }
                jedatos.setText(texto);
                if (malc && mali && mals && malp && malcp && malnif && malt && malnad){//ESCRIBIR DATOS
                    texto = "";
                    if (!direccion.getText().equals("")){
                        rsscalelabel.RSScaleLabel.setScaleLabel(imagen, archivo.toString());
                        imagen.setVisible(true);
                        texto += "<b>Imagen:</b><p></p><p></p><p></p><p></p><p></p>";
                    }
                    texto += "<<b> Nombre: </b>" + field[0].getText();
                    texto += "&nbsp &nbsp &nbsp <b> Apellidos: </b>" + field[1].getText();
                    texto += "<br><br>" + "<b> Dirección: </b>" + field[2].getText();
                    texto += "&nbsp &nbsp <b>" + label[6].getText() + ":" + "</b>" + field[3].getText();
                    texto += "<br><br>" + "<b> NIF: </b>" + field[4].getText();
                    texto += "&nbsp &nbsp <b> CP: </b>" + field[5].getText();
                    texto += "<br><br>" + "<b> Email: </b>" + field[6].getText();
                    texto += "&nbsp &nbsp <b> Contraseña: </b>" + field[7].getText();
                    texto += "<br><br>" + "<b> Pais: </>" + jcpais.getSelectedItem();
                    texto += "&nbsp &nbsp <b> Provincia: </b>" + jcprovincia.getSelectedItem();
                    texto += "&nbsp &nbsp <b> Poblacion: </b>" + field[8].getText();
                    texto += "<br><br> <b> Sexo: </b>" + sexo;
                    idiomasotros = field[9].getText();
                    texto += "<br><br> <b> Idiomas: </b>" + idiomae + idiomai + idiomaf + idiomaa + idiomait + idiomasotros;
                    texto += "<br><br> <b> Carta de presentación: </b>";
                    texto += "<br>" + tacarta.getText().replaceAll("\n", "<br>") + "<br>";
                    jedatos.setText(texto);
                }
            }
        });
    }

    //Método que permite subir una imagen
    private void botonim(){
        //creamos y colocamos el boton
        jbgenerar = new JButton("Subir imagen");
        jbgenerar.setBounds(540,525,150,50);
        add(jbgenerar);
        jbgenerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //hago visibles le field y ellabel al pulsar
                direccion.setVisible(true);
                textodireccion.setVisible(true);
                //Creamos un objeto filechoser para explorar archivos
                buscador = new JFileChooser();
                //Le añadimos que solo podamos elegir ficheros y direcotios
                buscador.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                //Queremos que solo aparezacan los que tengan las siguientes extensiones
                filtro = new FileNameExtensionFilter("*.JPEG", "jpeg","png","PNG","jpg","JPG");
                //Aplicamos el "filtro"
                buscador.setFileFilter(filtro);
                //Guardamos en un entero la accion generada al pulsar en el explorador
                seleccion = buscador.showOpenDialog(null);
                //Si hemos dados en el explorador en aceptar...
                if (seleccion==JFileChooser.APPROVE_OPTION) {
                    //Guardamos en el objeto tipo file el archivo seleccionado
                    archivo = buscador.getSelectedFile();
                    //Escribimos la ruta del archivo en el textfield
                    direccion.setText(archivo.getAbsolutePath());
                }
            }
        });
    }

    //Método qye ajusta la ventana
    private void initventana() {
        setLayout(null);
        setBounds(0, 0, 1280, 790);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    //Método principal que ejecuta al resto de métodos
    public static void main (String[] args){
        Formulario formularo = new Formulario();
    }
}

