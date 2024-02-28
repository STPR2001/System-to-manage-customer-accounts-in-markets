package views;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import logic.classes.AccountUser;
import logic.classes.Account;
import logic.classes.Debt;
import logic.classes.Organization;
import logic.classes.Payment;
import logic.classes.User;
import logic.factories.Factory;
import logic.interfaces.IAccountController;
import logic.interfaces.IAuthController;
import logic.interfaces.IOrganizationController;
import logic.interfaces.ITransactionController;
import logic.interfaces.IUserController;
import logic.interfaces.IEmailController;
import org.mindrot.jbcrypt.BCrypt;
public class Home extends javax.swing.JFrame {

    private ArrayList<AccountUser> clients;
    private IOrganizationController ICO;
    private IAuthController ICA;
    private IUserController ICU;
    private IAccountController ICAccount;
    private ITransactionController ICT;
    private IEmailController IEC;
    private int ownerId;
    private int organizationId;
    CardLayout cardLayout;
    CardLayout mainLayout;
    
    Color mouseEntered = new Color(129,165,226);
    Color mouseExited = new Color (81,102,138);
    
    private ArrayList<AccountUser> accountsInfo = null;
    private Organization organization;
    private User user;
    
    public Home(int ownerId) {
        this.ownerId=ownerId;
        this.ICT = Factory.getInstance().getTransactionController();
        this.ICU =Factory.getInstance().getUserController();
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.homeTransactionButtonNewTransaction.setVisible(false);
        this.organizationsTable.getTableHeader().setFont( new Font( "Arial" , Font.BOLD, 18 ));
        this.homeAccountTable.getTableHeader().setFont( new Font( "Arial" , Font.BOLD, 18 ));
        this.homeTransactionSaleTable.getTableHeader().setFont( new Font( "Arial" , Font.BOLD, 18 ));
        this.homeTransactionPaymentTable.getTableHeader().setFont( new Font( "Arial" , Font.BOLD, 18 ));
        
        DefaultTableCellRenderer centrarCeldas = new DefaultTableCellRenderer();
        centrarCeldas.setHorizontalAlignment(JLabel.CENTER);
        
        for (int i = 0; i< this.organizationsTable.getColumnCount();i++){
            this.organizationsTable.getColumnModel().getColumn(i).setCellRenderer(centrarCeldas);
        }
        for (int i=0;i< this.homeAccountTable.getColumnCount();i++){
            this.homeAccountTable.getColumnModel().getColumn(i).setCellRenderer(centrarCeldas);
        }
        for (int i=0;i< this.homeTransactionSaleTable.getColumnCount();i++){
            this.homeTransactionSaleTable.getColumnModel().getColumn(i).setCellRenderer(centrarCeldas);
        }
        for (int i=0;i< this.homeTransactionPaymentTable.getColumnCount();i++){
            this.homeTransactionPaymentTable.getColumnModel().getColumn(i).setCellRenderer(centrarCeldas);
        }
        
        mainLayout = (CardLayout)(mainCards.getLayout());
        cardLayout = (CardLayout)(panelCards.getLayout());
        
        mainLayout.show(mainCards, "mainCard1");
        cardLayout.show(panelCards,"panelCard1");
        
        this.ICO = Factory.getInstance().getOrganizationController();
        this.ICAccount = Factory.getInstance().getAccountController();
        this.loadOrganizationsOnTable();
        
    }
    public Home(){
        initComponents();
    }

    public int getOwnerId() {
        return ownerId;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        organizationDialogNewOrganization = new javax.swing.JDialog();
        organizationDialogPanel = new javax.swing.JPanel();
        organizationDialogButtonAdd = new javax.swing.JButton();
        organizationDialogTextFieldPassword = new javax.swing.JTextField();
        organizationDialogTextFieldDetail = new javax.swing.JTextField();
        organizationDialogTitle = new javax.swing.JLabel();
        organizationDialogTextFieldName = new javax.swing.JTextField();
        organizationDialogNameTitle = new javax.swing.JLabel();
        organizationDialogDetailTitle = new javax.swing.JLabel();
        organizationDialogPasswordTitle = new javax.swing.JLabel();
        organizationDialogLabelPublicTitle = new javax.swing.JLabel();
        organizationDialogPublicCheckBox = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        organizationDialogLabelPublicNote = new javax.swing.JLabel();
        transactionDialogNewPayLabelAccountTitle1 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        addressTextField = new javax.swing.JTextField();
        organizationDialogNameTitle1 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxAddressOrganization = new javax.swing.JComboBox<>();
        transactionDialogOptions = new javax.swing.JDialog();
        transactionDialogOptionsPanel = new javax.swing.JPanel();
        transactionDialogOptionsTitle = new javax.swing.JLabel();
        transactionDialogOptionsButtonSale = new javax.swing.JButton();
        transactionDialogOptionsButtonPayment = new javax.swing.JButton();
        transactionDialogOptionButtonBack = new javax.swing.JButton();
        transactionDialogNewPay = new javax.swing.JDialog();
        transactionDialogNewPayPanel = new javax.swing.JPanel();
        transactionDialogNewPayLabelTitle = new javax.swing.JLabel();
        transactionDialogNewPayLabelAccountTitle = new javax.swing.JLabel();
        transactionDialogNewPayLabelTotalAmountTitle = new javax.swing.JLabel();
        transactionDialogNewPayLabelTotalAmount = new javax.swing.JTextField();
        transactionDialogNewPayButtonCreate = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        transactionDialogNewPayLabelNote = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        transactionDialogNewPayComboBox = new javax.swing.JComboBox<>();
        transactionDialogNewSale = new javax.swing.JDialog();
        transactionDialogNewSalePanel = new javax.swing.JPanel();
        transactionDialogNewSaleLabelTitle = new javax.swing.JLabel();
        transactionDialogNewSaleLabelAccountIdTitle = new javax.swing.JLabel();
        transactionDialogNewSaleLabelDetailTitle = new javax.swing.JLabel();
        transactionDialogNewSaleLabelInitialPaymentTitle = new javax.swing.JLabel();
        transactionDialogNewSaleLabelDetail = new javax.swing.JTextField();
        transactionDialogNewSaleButtonCreate = new javax.swing.JButton();
        transactionDialogNewSaleLabelInitialPayment = new javax.swing.JTextField();
        transactionDialogNewSaleTotalAmount = new javax.swing.JTextField();
        transactionDialogNewSaleTotalAmountTitle = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        transactionDialogNewSaleLabelNote2 = new javax.swing.JLabel();
        transactionDialogNewSaleLabelNote1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        accountDialogNew = new javax.swing.JDialog();
        createAccountPanel = new javax.swing.JPanel();
        accountDialogNewTitle = new javax.swing.JLabel();
        accountDialogNewTitleCorreo = new javax.swing.JLabel();
        accountDialogNewTitleLimit = new javax.swing.JLabel();
        accountDialogNewTitlePassword = new javax.swing.JLabel();
        accountDialogNewCorreoLabel = new javax.swing.JTextField();
        accountDialogNewLimitLabel = new javax.swing.JTextField();
        accountDialogNewCreateButton = new javax.swing.JButton();
        accountDialogNewPasswordLabel = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        transactionDialogSaleDetails = new javax.swing.JDialog();
        transactionDialogSaleDetailsPanel = new javax.swing.JPanel();
        transactionDialogSaleDetailsPanel4 = new javax.swing.JPanel();
        transactionDialogSaleDetailsLabelDetail = new javax.swing.JLabel();
        transactionDialogSaleDetailsLabelTitle = new javax.swing.JLabel();
        transactionDialogSaleDetailsPanel1 = new javax.swing.JPanel();
        transactionDialogSaleDetailsLabelSaleId = new javax.swing.JLabel();
        transactionDialogSaleDetailsLabelSaleIdTitle = new javax.swing.JLabel();
        transactionDialogSaleDetailsLabelAccountIdTitle = new javax.swing.JLabel();
        transactionDialogSaleDetailsLabelAccountId = new javax.swing.JLabel();
        transactionDialogSaleDetailsLabelStatusTitle = new javax.swing.JLabel();
        transactionDialogSaleDetailsLabelStatus = new javax.swing.JLabel();
        transactionDialogSaleDetailsPanel2 = new javax.swing.JPanel();
        transactionDialogSaleDetailsLabelCreated = new javax.swing.JLabel();
        transactionDialogSaleDetailsLabelCreatedTitle = new javax.swing.JLabel();
        transactionDialogSaleDetailsPanel3 = new javax.swing.JPanel();
        transactionDialogSaleDetailsLabelUpdated = new javax.swing.JLabel();
        transactionDialogSaleDetailsLabelUpdatedTitle = new javax.swing.JLabel();
        transactionDialogSaleDetailsLabelTotalAmountTitle = new javax.swing.JLabel();
        transactionDialogSaleDetailsLabelDetailTitle = new javax.swing.JLabel();
        transactionDialogSaleDetailsLabelInitialPayTitle = new javax.swing.JLabel();
        transactionDialogSaleDetailsPanel5 = new javax.swing.JPanel();
        transactionDialogSaleDetailsLabelNote1 = new javax.swing.JLabel();
        transactionDialogSaleDetailsLabelInitialPay = new javax.swing.JLabel();
        transactionDialogSaleDetailsPanel6 = new javax.swing.JPanel();
        transactionDialogSaleDetailsLabelNote2 = new javax.swing.JLabel();
        transactionDialogSaleDetailsLabelTotalAmount = new javax.swing.JLabel();
        transactionDialogSaleDetailsButtonBack = new javax.swing.JButton();
        transactionDialogPaymentDetails = new javax.swing.JDialog();
        transactionDialogPaymentDetailsPanel = new javax.swing.JPanel();
        transactionDialogPaymentDetailsLabelTitle = new javax.swing.JLabel();
        transactionDialogPaymentDetailsPanel1 = new javax.swing.JPanel();
        transactionDialogPaymentDetailsLabelPaymentId = new javax.swing.JLabel();
        transactionDialogPaymentDetailsLabelPaymentIdTitle = new javax.swing.JLabel();
        transactionDialogPaymentDetailsLabelAccountIdTitle = new javax.swing.JLabel();
        transactionDialogPaymentDetailsLabelAccountId = new javax.swing.JLabel();
        transactionDialogPaymentDetailsLabelUserIdTitle = new javax.swing.JLabel();
        transactionDialogPaymentDetailsLabelUserId = new javax.swing.JLabel();
        transactionDialogPaymentDetailsPanel2 = new javax.swing.JPanel();
        transactionDialogPaymentDetailsLabelCreated = new javax.swing.JLabel();
        transactionDialogPaymentDetailsLabelCreatedTitle = new javax.swing.JLabel();
        transactionDialogPaymentDetailsPanel3 = new javax.swing.JPanel();
        transactionDialogPaymentDetailsLabelUpdated = new javax.swing.JLabel();
        transactionDialogPaymentDetailsLabelUpdatedTitle = new javax.swing.JLabel();
        transactionDialogPaymentDetailsLabelTotalAmountTitle = new javax.swing.JLabel();
        transactionDialogPaymentDetailsLabelStatusTitle = new javax.swing.JLabel();
        transactionDialogPaymentDetailsPanel4 = new javax.swing.JPanel();
        transactionDialogPaymentDetailsLabelStatus = new javax.swing.JLabel();
        transactionDialogPaymentDetailsPanel5 = new javax.swing.JPanel();
        transactionDialogPaymentDetailsLabelNote1 = new javax.swing.JLabel();
        transactionDialogPaymentDetailsLabelTotalAmount = new javax.swing.JLabel();
        transactionDialogPaymentDetailsButtonBack = new javax.swing.JButton();
        accountDialogDetails = new javax.swing.JDialog();
        accountDetailsPanel = new javax.swing.JPanel();
        accountName = new javax.swing.JLabel();
        goBack = new javax.swing.JButton();
        limitAmount = new javax.swing.JLabel();
        priceSymbol = new javax.swing.JLabel();
        totalAmount = new javax.swing.JLabel();
        accountAddress = new javax.swing.JLabel();
        accountEmail = new javax.swing.JLabel();
        transactionsLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        accountDetailsDebtTransactions = new javax.swing.JTable();
        mainCards = new javax.swing.JPanel();
        mainCard1 = new javax.swing.JPanel();
        organizationLabelTitle = new javax.swing.JLabel();
        organizationScrollPaneTable = new javax.swing.JScrollPane();
        organizationsTable = new javax.swing.JTable();
        organizationLabelNote = new javax.swing.JLabel();
        organizationButtonNewOrganization = new javax.swing.JButton();
        organizationButtonLogOff = new javax.swing.JButton();
        mainCard2 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanelWithButtons = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        homeButtonDetails = new javax.swing.JButton();
        homeButtonTransactions = new javax.swing.JButton();
        homeLabelYourOrgName = new javax.swing.JLabel();
        homeButtonBack = new javax.swing.JButton();
        homeButtonAccounts = new javax.swing.JButton();
        panelCards = new javax.swing.JPanel();
        panelCard1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        homeDetailsLabelDetailTitle = new javax.swing.JLabel();
        homeDetailsLabelDetail = new javax.swing.JLabel();
        organizationLabelTitle2 = new javax.swing.JLabel();
        panelCard2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        homeAccountTable = new javax.swing.JTable();
        homeAccountLabelAccountAmountTitle = new javax.swing.JLabel();
        homeAccountLabelAccountAmount = new javax.swing.JLabel();
        homeAccountTextFieldSearch = new javax.swing.JTextField();
        homeAccountLabelSearchTitle = new javax.swing.JLabel();
        homeAccountButtonNewAccount = new javax.swing.JButton();
        homeAccountButtonUpdateAccount = new javax.swing.JButton();
        homeAccountLabelTitle = new javax.swing.JLabel();
        panelCard3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        homeTransactionLabelSaleTitle = new javax.swing.JLabel();
        homeTransactionLabelPaymentTitle = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        homeTransactionSaleTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        homeTransactionPaymentTable = new javax.swing.JTable();
        homeTransactionButtonNewTransaction = new javax.swing.JButton();
        homeTransactionLabelTitle = new javax.swing.JLabel();
        organizationLabelTitle1 = new javax.swing.JLabel();

        organizationDialogNewOrganization.setTitle("Crear una organización");
        organizationDialogNewOrganization.setBackground(new java.awt.Color(204, 204, 204));
        organizationDialogNewOrganization.setMinimumSize(new java.awt.Dimension(630, 700));
        organizationDialogNewOrganization.setModal(true);
        organizationDialogNewOrganization.setResizable(false);
        organizationDialogNewOrganization.setSize(new java.awt.Dimension(400, 700));

        organizationDialogPanel.setBackground(new java.awt.Color(33, 33, 33));

        organizationDialogButtonAdd.setBackground(new java.awt.Color(81, 102, 138));
        organizationDialogButtonAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        organizationDialogButtonAdd.setForeground(new java.awt.Color(255, 255, 255));
        organizationDialogButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tick.png"))); // NOI18N
        organizationDialogButtonAdd.setText("AGREGAR ORGANIZACIÓN");
        organizationDialogButtonAdd.setBorder(null);
        organizationDialogButtonAdd.setBorderPainted(false);
        organizationDialogButtonAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                organizationDialogButtonAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                organizationDialogButtonAddMouseExited(evt);
            }
        });
        organizationDialogButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationDialogButtonAddActionPerformed(evt);
            }
        });

        organizationDialogTextFieldPassword.setBackground(new java.awt.Color(33, 33, 33));
        organizationDialogTextFieldPassword.setForeground(new java.awt.Color(153, 153, 153));
        organizationDialogTextFieldPassword.setText("*******************");
        organizationDialogTextFieldPassword.setBorder(null);
        organizationDialogTextFieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationDialogTextFieldPasswordActionPerformed(evt);
            }
        });

        organizationDialogTextFieldDetail.setBackground(new java.awt.Color(33, 33, 33));
        organizationDialogTextFieldDetail.setForeground(new java.awt.Color(153, 153, 153));
        organizationDialogTextFieldDetail.setText("Ingresa una breve descripciön");
        organizationDialogTextFieldDetail.setBorder(null);

        organizationDialogTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        organizationDialogTitle.setForeground(new java.awt.Color(255, 255, 255));
        organizationDialogTitle.setText("CREAR ORGANIZACIÓN");

        organizationDialogTextFieldName.setBackground(new java.awt.Color(33, 33, 33));
        organizationDialogTextFieldName.setForeground(new java.awt.Color(153, 153, 153));
        organizationDialogTextFieldName.setText("Ingresa el nombre de tu organización");
        organizationDialogTextFieldName.setBorder(null);
        organizationDialogTextFieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationDialogTextFieldNameActionPerformed(evt);
            }
        });

        organizationDialogNameTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        organizationDialogNameTitle.setForeground(new java.awt.Color(255, 255, 255));
        organizationDialogNameTitle.setText("NOMBRE");

        organizationDialogDetailTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        organizationDialogDetailTitle.setForeground(new java.awt.Color(255, 255, 255));
        organizationDialogDetailTitle.setText("DESCRIPCIÓN");

        organizationDialogPasswordTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        organizationDialogPasswordTitle.setForeground(new java.awt.Color(255, 255, 255));
        organizationDialogPasswordTitle.setText("CONTRASEÑA");

        organizationDialogLabelPublicTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        organizationDialogLabelPublicTitle.setForeground(new java.awt.Color(255, 255, 255));
        organizationDialogLabelPublicTitle.setText("ORG. PÚBLICA");

        organizationDialogPublicCheckBox.setBackground(new java.awt.Color(33, 33, 33));
        organizationDialogPublicCheckBox.setMaximumSize(new java.awt.Dimension(50, 50));
        organizationDialogPublicCheckBox.setMinimumSize(new java.awt.Dimension(50, 50));
        organizationDialogPublicCheckBox.setPreferredSize(new java.awt.Dimension(50, 50));
        organizationDialogPublicCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationDialogPublicCheckBoxActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        organizationDialogLabelPublicNote.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        organizationDialogLabelPublicNote.setForeground(new java.awt.Color(255, 255, 255));
        organizationDialogLabelPublicNote.setText("(MARCAR CASILLA)");

        transactionDialogNewPayLabelAccountTitle1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        transactionDialogNewPayLabelAccountTitle1.setForeground(new java.awt.Color(255, 255, 255));
        transactionDialogNewPayLabelAccountTitle1.setText("CIUDAD");

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        addressTextField.setBackground(new java.awt.Color(33, 33, 33));
        addressTextField.setForeground(new java.awt.Color(153, 153, 153));
        addressTextField.setText("Ingresa la dirección de tu organización");
        addressTextField.setBorder(null);
        addressTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTextFieldActionPerformed(evt);
            }
        });

        organizationDialogNameTitle1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        organizationDialogNameTitle1.setForeground(new java.awt.Color(255, 255, 255));
        organizationDialogNameTitle1.setText("DIRECCIÓN");

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));

        jComboBoxAddressOrganization.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Artigas",
            "Canelones",
            "Cerro Largo",
            "Colonia",
            "Durazno",
            "Flores",
            "Florida",
            "Lavalleja",
            "Maldonado",
            "Montevideo",
            "Paysandú",
            "Río Negro",
            "Rivera",
            "Rocha",
            "Salto",
            "San José",
            "Soriano",
            "Tacuarembó",
            "Treinta y Tres" }));
jComboBoxAddressOrganization.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        jComboBoxAddressOrganizationActionPerformed(evt);
    }
    });

    javax.swing.GroupLayout organizationDialogPanelLayout = new javax.swing.GroupLayout(organizationDialogPanel);
    organizationDialogPanel.setLayout(organizationDialogPanelLayout);
    organizationDialogPanelLayout.setHorizontalGroup(
        organizationDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(organizationDialogPanelLayout.createSequentialGroup()
            .addGroup(organizationDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(organizationDialogPanelLayout.createSequentialGroup()
                    .addGap(170, 170, 170)
                    .addGroup(organizationDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(organizationDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(organizationDialogNameTitle1)
                            .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(organizationDialogPasswordTitle)
                            .addComponent(organizationDialogTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(organizationDialogTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator4)
                            .addComponent(jComboBoxAddressOrganization, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator2)
                            .addComponent(organizationDialogDetailTitle)
                            .addComponent(organizationDialogNameTitle)
                            .addComponent(organizationDialogTextFieldName)
                            .addComponent(organizationDialogTextFieldDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(transactionDialogNewPayLabelAccountTitle1)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator3)
                            .addComponent(jSeparator5)
                            .addComponent(organizationDialogButtonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(organizationDialogPanelLayout.createSequentialGroup()
                            .addComponent(organizationDialogLabelPublicNote)
                            .addGap(90, 90, 90)
                            .addComponent(organizationDialogPublicCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(organizationDialogLabelPublicTitle)))
                .addGroup(organizationDialogPanelLayout.createSequentialGroup()
                    .addGap(196, 196, 196)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(203, Short.MAX_VALUE))
    );
    organizationDialogPanelLayout.setVerticalGroup(
        organizationDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, organizationDialogPanelLayout.createSequentialGroup()
            .addGap(30, 30, 30)
            .addComponent(organizationDialogTitle)
            .addGap(18, 18, 18)
            .addComponent(organizationDialogNameTitle)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(organizationDialogTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(organizationDialogDetailTitle)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(organizationDialogTextFieldDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(transactionDialogNewPayLabelAccountTitle1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jComboBoxAddressOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(organizationDialogNameTitle1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(organizationDialogPasswordTitle)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(organizationDialogTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(1, 1, 1)
            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(organizationDialogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(organizationDialogPanelLayout.createSequentialGroup()
                    .addComponent(organizationDialogLabelPublicTitle)
                    .addGap(8, 8, 8)
                    .addComponent(organizationDialogLabelPublicNote))
                .addComponent(organizationDialogPublicCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(30, 30, 30)
            .addComponent(organizationDialogButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(11, 11, 11))
    );

    javax.swing.GroupLayout organizationDialogNewOrganizationLayout = new javax.swing.GroupLayout(organizationDialogNewOrganization.getContentPane());
    organizationDialogNewOrganization.getContentPane().setLayout(organizationDialogNewOrganizationLayout);
    organizationDialogNewOrganizationLayout.setHorizontalGroup(
        organizationDialogNewOrganizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(organizationDialogPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    organizationDialogNewOrganizationLayout.setVerticalGroup(
        organizationDialogNewOrganizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(organizationDialogPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    transactionDialogOptions.setTitle("Seleccionar tipo de transacción");
    transactionDialogOptions.setMinimumSize(new java.awt.Dimension(450, 450));
    transactionDialogOptions.setModal(true);
    transactionDialogOptions.setResizable(false);
    transactionDialogOptions.setSize(new java.awt.Dimension(400, 400));

    transactionDialogOptionsPanel.setBackground(new java.awt.Color(33, 33, 33));
    transactionDialogOptionsPanel.setMaximumSize(new java.awt.Dimension(400, 400));
    transactionDialogOptionsPanel.setMinimumSize(new java.awt.Dimension(400, 400));

    transactionDialogOptionsTitle.setBackground(new java.awt.Color(12, 36, 49));
    transactionDialogOptionsTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    transactionDialogOptionsTitle.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogOptionsTitle.setText("SELECCIONAR TIPO DE TRANSACCIÓN");

    transactionDialogOptionsButtonSale.setBackground(new java.awt.Color(81, 102, 138));
    transactionDialogOptionsButtonSale.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    transactionDialogOptionsButtonSale.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogOptionsButtonSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_sale.png"))); // NOI18N
    transactionDialogOptionsButtonSale.setText("VENTA");
    transactionDialogOptionsButtonSale.setBorder(null);
    transactionDialogOptionsButtonSale.setBorderPainted(false);
    transactionDialogOptionsButtonSale.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            transactionDialogOptionsButtonSaleMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            transactionDialogOptionsButtonSaleMouseExited(evt);
        }
    });
    transactionDialogOptionsButtonSale.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            transactionDialogOptionsButtonSaleActionPerformed(evt);
        }
    });

    transactionDialogOptionsButtonPayment.setBackground(new java.awt.Color(81, 102, 138));
    transactionDialogOptionsButtonPayment.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    transactionDialogOptionsButtonPayment.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogOptionsButtonPayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add pay.png"))); // NOI18N
    transactionDialogOptionsButtonPayment.setText("PAGO");
    transactionDialogOptionsButtonPayment.setBorder(null);
    transactionDialogOptionsButtonPayment.setBorderPainted(false);
    transactionDialogOptionsButtonPayment.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            transactionDialogOptionsButtonPaymentMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            transactionDialogOptionsButtonPaymentMouseExited(evt);
        }
    });
    transactionDialogOptionsButtonPayment.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            transactionDialogOptionsButtonPaymentActionPerformed(evt);
        }
    });

    transactionDialogOptionButtonBack.setBackground(new java.awt.Color(81, 102, 138));
    transactionDialogOptionButtonBack.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    transactionDialogOptionButtonBack.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogOptionButtonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go_back.png"))); // NOI18N
    transactionDialogOptionButtonBack.setText("VOLVER");
    transactionDialogOptionButtonBack.setBorder(null);
    transactionDialogOptionButtonBack.setBorderPainted(false);
    transactionDialogOptionButtonBack.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            transactionDialogOptionButtonBackMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            transactionDialogOptionButtonBackMouseExited(evt);
        }
    });
    transactionDialogOptionButtonBack.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            transactionDialogOptionButtonBackActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout transactionDialogOptionsPanelLayout = new javax.swing.GroupLayout(transactionDialogOptionsPanel);
    transactionDialogOptionsPanel.setLayout(transactionDialogOptionsPanelLayout);
    transactionDialogOptionsPanelLayout.setHorizontalGroup(
        transactionDialogOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogOptionsPanelLayout.createSequentialGroup()
            .addGroup(transactionDialogOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(transactionDialogOptionsPanelLayout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(transactionDialogOptionsTitle))
                .addGroup(transactionDialogOptionsPanelLayout.createSequentialGroup()
                    .addGap(153, 153, 153)
                    .addGroup(transactionDialogOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(transactionDialogOptionButtonBack, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                        .addComponent(transactionDialogOptionsButtonPayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(transactionDialogOptionsButtonSale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addContainerGap(71, Short.MAX_VALUE))
    );
    transactionDialogOptionsPanelLayout.setVerticalGroup(
        transactionDialogOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogOptionsPanelLayout.createSequentialGroup()
            .addGap(41, 41, 41)
            .addComponent(transactionDialogOptionsTitle)
            .addGap(44, 44, 44)
            .addComponent(transactionDialogOptionsButtonSale, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(37, 37, 37)
            .addComponent(transactionDialogOptionsButtonPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
            .addComponent(transactionDialogOptionButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(19, 19, 19))
    );

    javax.swing.GroupLayout transactionDialogOptionsLayout = new javax.swing.GroupLayout(transactionDialogOptions.getContentPane());
    transactionDialogOptions.getContentPane().setLayout(transactionDialogOptionsLayout);
    transactionDialogOptionsLayout.setHorizontalGroup(
        transactionDialogOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(transactionDialogOptionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    transactionDialogOptionsLayout.setVerticalGroup(
        transactionDialogOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(transactionDialogOptionsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    transactionDialogNewPay.setTitle("Crear nueva transacción (Pago)");
    transactionDialogNewPay.setModal(true);
    transactionDialogNewPay.setResizable(false);
    transactionDialogNewPay.setSize(new java.awt.Dimension(450, 500));

    transactionDialogNewPayPanel.setBackground(new java.awt.Color(33, 33, 33));

    transactionDialogNewPayLabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    transactionDialogNewPayLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogNewPayLabelTitle.setText("NUEVO PAGO");

    transactionDialogNewPayLabelAccountTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    transactionDialogNewPayLabelAccountTitle.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogNewPayLabelAccountTitle.setText("CUENTA");

    transactionDialogNewPayLabelTotalAmountTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    transactionDialogNewPayLabelTotalAmountTitle.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogNewPayLabelTotalAmountTitle.setText("TOTAL");

    transactionDialogNewPayLabelTotalAmount.setBackground(new java.awt.Color(33, 33, 33));
    transactionDialogNewPayLabelTotalAmount.setForeground(new java.awt.Color(153, 153, 153));
    transactionDialogNewPayLabelTotalAmount.setText("Ingresa el Monto Total");
    transactionDialogNewPayLabelTotalAmount.setBorder(null);
    transactionDialogNewPayLabelTotalAmount.setCaretColor(new java.awt.Color(153, 153, 153));

    transactionDialogNewPayButtonCreate.setBackground(new java.awt.Color(81, 102, 138));
    transactionDialogNewPayButtonCreate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    transactionDialogNewPayButtonCreate.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogNewPayButtonCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tick.png"))); // NOI18N
    transactionDialogNewPayButtonCreate.setText("CREAR PAGO");
    transactionDialogNewPayButtonCreate.setBorder(null);
    transactionDialogNewPayButtonCreate.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            transactionDialogNewPayButtonCreateMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            transactionDialogNewPayButtonCreateMouseExited(evt);
        }
    });
    transactionDialogNewPayButtonCreate.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            transactionDialogNewPayButtonCreateActionPerformed(evt);
        }
    });

    jSeparator6.setForeground(new java.awt.Color(255, 255, 255));

    transactionDialogNewPayLabelNote.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    transactionDialogNewPayLabelNote.setForeground(new java.awt.Color(12, 36, 49));
    transactionDialogNewPayLabelNote.setText("$");

    jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(255, 0, 0));

    transactionDialogNewPayComboBox.setBackground(new java.awt.Color(33, 33, 33));
    transactionDialogNewPayComboBox.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogNewPayComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "lucas", "burno", "luciano" }));
    transactionDialogNewPayComboBox.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            transactionDialogNewPayComboBoxActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout transactionDialogNewPayPanelLayout = new javax.swing.GroupLayout(transactionDialogNewPayPanel);
    transactionDialogNewPayPanel.setLayout(transactionDialogNewPayPanelLayout);
    transactionDialogNewPayPanelLayout.setHorizontalGroup(
        transactionDialogNewPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogNewPayPanelLayout.createSequentialGroup()
            .addGap(69, 69, 69)
            .addComponent(transactionDialogNewPayLabelNote)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(transactionDialogNewPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(transactionDialogNewPayPanelLayout.createSequentialGroup()
                    .addGroup(transactionDialogNewPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(transactionDialogNewPayComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(transactionDialogNewPayPanelLayout.createSequentialGroup()
                            .addComponent(transactionDialogNewPayLabelAccountTitle)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGap(51, 51, 51))
                .addGroup(transactionDialogNewPayPanelLayout.createSequentialGroup()
                    .addGroup(transactionDialogNewPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(transactionDialogNewPayLabelTotalAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                        .addGroup(transactionDialogNewPayPanelLayout.createSequentialGroup()
                            .addGroup(transactionDialogNewPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(transactionDialogNewPayLabelTotalAmountTitle)
                                .addGroup(transactionDialogNewPayPanelLayout.createSequentialGroup()
                                    .addGap(37, 37, 37)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())))
        .addGroup(transactionDialogNewPayPanelLayout.createSequentialGroup()
            .addGroup(transactionDialogNewPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(transactionDialogNewPayPanelLayout.createSequentialGroup()
                    .addGap(126, 126, 126)
                    .addComponent(transactionDialogNewPayButtonCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(transactionDialogNewPayPanelLayout.createSequentialGroup()
                    .addGap(145, 145, 145)
                    .addComponent(transactionDialogNewPayLabelTitle)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    transactionDialogNewPayPanelLayout.setVerticalGroup(
        transactionDialogNewPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transactionDialogNewPayPanelLayout.createSequentialGroup()
            .addGap(32, 32, 32)
            .addComponent(transactionDialogNewPayLabelTitle)
            .addGap(63, 63, 63)
            .addComponent(transactionDialogNewPayLabelAccountTitle)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(transactionDialogNewPayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(transactionDialogNewPayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(transactionDialogNewPayPanelLayout.createSequentialGroup()
                    .addGap(110, 110, 110)
                    .addComponent(transactionDialogNewPayLabelNote)
                    .addGap(53, 53, 53))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transactionDialogNewPayPanelLayout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(transactionDialogNewPayLabelTotalAmountTitle)
                    .addGap(4, 4, 4)
                    .addComponent(transactionDialogNewPayLabelTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(31, 31, 31)))
            .addComponent(transactionDialogNewPayButtonCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(56, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout transactionDialogNewPayLayout = new javax.swing.GroupLayout(transactionDialogNewPay.getContentPane());
    transactionDialogNewPay.getContentPane().setLayout(transactionDialogNewPayLayout);
    transactionDialogNewPayLayout.setHorizontalGroup(
        transactionDialogNewPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(transactionDialogNewPayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    transactionDialogNewPayLayout.setVerticalGroup(
        transactionDialogNewPayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(transactionDialogNewPayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    transactionDialogNewSale.setTitle("Crear nueva transacción (Venta)");
    transactionDialogNewSale.setBackground(new java.awt.Color(255, 255, 255));
    transactionDialogNewSale.setModal(true);
    transactionDialogNewSale.setResizable(false);
    transactionDialogNewSale.setSize(new java.awt.Dimension(450, 500));

    transactionDialogNewSalePanel.setBackground(new java.awt.Color(33, 33, 33));

    transactionDialogNewSaleLabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    transactionDialogNewSaleLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogNewSaleLabelTitle.setText("INGRESA LOS DATOS");

    transactionDialogNewSaleLabelAccountIdTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    transactionDialogNewSaleLabelAccountIdTitle.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogNewSaleLabelAccountIdTitle.setText("CUENTA");

    transactionDialogNewSaleLabelDetailTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    transactionDialogNewSaleLabelDetailTitle.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogNewSaleLabelDetailTitle.setText("DETALLE");

    transactionDialogNewSaleLabelInitialPaymentTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    transactionDialogNewSaleLabelInitialPaymentTitle.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogNewSaleLabelInitialPaymentTitle.setText("PAGO INICIAL");

    transactionDialogNewSaleLabelDetail.setBackground(new java.awt.Color(33, 33, 33));
    transactionDialogNewSaleLabelDetail.setForeground(new java.awt.Color(153, 153, 153));
    transactionDialogNewSaleLabelDetail.setText("Ingresa una breve descripción");
    transactionDialogNewSaleLabelDetail.setBorder(null);
    transactionDialogNewSaleLabelDetail.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            transactionDialogNewSaleLabelDetailActionPerformed(evt);
        }
    });

    transactionDialogNewSaleButtonCreate.setBackground(new java.awt.Color(81, 102, 138));
    transactionDialogNewSaleButtonCreate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    transactionDialogNewSaleButtonCreate.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogNewSaleButtonCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tick.png"))); // NOI18N
    transactionDialogNewSaleButtonCreate.setText("CREAR VENTA");
    transactionDialogNewSaleButtonCreate.setBorder(null);
    transactionDialogNewSaleButtonCreate.setBorderPainted(false);
    transactionDialogNewSaleButtonCreate.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            transactionDialogNewSaleButtonCreateMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            transactionDialogNewSaleButtonCreateMouseExited(evt);
        }
    });
    transactionDialogNewSaleButtonCreate.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            transactionDialogNewSaleButtonCreateActionPerformed(evt);
        }
    });

    transactionDialogNewSaleLabelInitialPayment.setBackground(new java.awt.Color(33, 33, 33));
    transactionDialogNewSaleLabelInitialPayment.setForeground(new java.awt.Color(153, 153, 153));
    transactionDialogNewSaleLabelInitialPayment.setText("Ingresa el pago inicial");
    transactionDialogNewSaleLabelInitialPayment.setBorder(null);
    transactionDialogNewSaleLabelInitialPayment.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            transactionDialogNewSaleLabelInitialPaymentActionPerformed(evt);
        }
    });

    transactionDialogNewSaleTotalAmount.setBackground(new java.awt.Color(33, 33, 33));
    transactionDialogNewSaleTotalAmount.setForeground(new java.awt.Color(153, 153, 153));
    transactionDialogNewSaleTotalAmount.setText("Ingresa el monto total");
    transactionDialogNewSaleTotalAmount.setBorder(null);
    transactionDialogNewSaleTotalAmount.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            transactionDialogNewSaleTotalAmountActionPerformed(evt);
        }
    });

    transactionDialogNewSaleTotalAmountTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    transactionDialogNewSaleTotalAmountTitle.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogNewSaleTotalAmountTitle.setText("TOTAL");

    jSeparator8.setForeground(new java.awt.Color(0, 0, 0));

    jSeparator9.setForeground(new java.awt.Color(0, 0, 0));

    jSeparator10.setForeground(new java.awt.Color(0, 0, 0));

    jSeparator11.setForeground(new java.awt.Color(0, 0, 0));

    transactionDialogNewSaleLabelNote2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    transactionDialogNewSaleLabelNote2.setForeground(new java.awt.Color(12, 36, 49));
    transactionDialogNewSaleLabelNote2.setText("$");

    transactionDialogNewSaleLabelNote1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    transactionDialogNewSaleLabelNote1.setForeground(new java.awt.Color(12, 36, 49));
    transactionDialogNewSaleLabelNote1.setText("$");

    jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(255, 0, 0));

    jComboBox1.setBackground(new java.awt.Color(33, 33, 33));
    jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "lucas", "burno", "luciano" }));
    jComboBox1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox1ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout transactionDialogNewSalePanelLayout = new javax.swing.GroupLayout(transactionDialogNewSalePanel);
    transactionDialogNewSalePanel.setLayout(transactionDialogNewSalePanelLayout);
    transactionDialogNewSalePanelLayout.setHorizontalGroup(
        transactionDialogNewSalePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogNewSalePanelLayout.createSequentialGroup()
            .addGap(132, 132, 132)
            .addComponent(transactionDialogNewSaleButtonCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(transactionDialogNewSalePanelLayout.createSequentialGroup()
            .addGap(51, 51, 51)
            .addGroup(transactionDialogNewSalePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(transactionDialogNewSaleLabelNote2)
                .addComponent(transactionDialogNewSaleLabelNote1))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(transactionDialogNewSalePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transactionDialogNewSalePanelLayout.createSequentialGroup()
                    .addGroup(transactionDialogNewSalePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(transactionDialogNewSaleTotalAmount, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, transactionDialogNewSalePanelLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(transactionDialogNewSaleLabelAccountIdTitle))
                        .addComponent(jSeparator10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
                    .addContainerGap(111, Short.MAX_VALUE))
                .addGroup(transactionDialogNewSalePanelLayout.createSequentialGroup()
                    .addGroup(transactionDialogNewSalePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(transactionDialogNewSaleTotalAmountTitle)
                        .addComponent(transactionDialogNewSaleLabelInitialPaymentTitle)
                        .addComponent(transactionDialogNewSaleLabelInitialPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(transactionDialogNewSalePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, transactionDialogNewSalePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(transactionDialogNewSaleLabelTitle)
                                .addGroup(transactionDialogNewSalePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                                    .addComponent(transactionDialogNewSaleLabelDetailTitle, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator9)
                                    .addComponent(transactionDialogNewSaleLabelDetail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE))))
    );
    transactionDialogNewSalePanelLayout.setVerticalGroup(
        transactionDialogNewSalePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transactionDialogNewSalePanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(transactionDialogNewSaleLabelTitle)
            .addGap(18, 18, 18)
            .addComponent(transactionDialogNewSaleLabelAccountIdTitle)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(transactionDialogNewSaleLabelDetailTitle)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(transactionDialogNewSaleLabelDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(transactionDialogNewSaleLabelInitialPaymentTitle)
            .addGap(13, 13, 13)
            .addGroup(transactionDialogNewSalePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(transactionDialogNewSaleLabelInitialPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(transactionDialogNewSaleLabelNote1))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(transactionDialogNewSaleTotalAmountTitle)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(transactionDialogNewSalePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(transactionDialogNewSaleTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(transactionDialogNewSaleLabelNote2))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(transactionDialogNewSaleButtonCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18))
    );

    javax.swing.GroupLayout transactionDialogNewSaleLayout = new javax.swing.GroupLayout(transactionDialogNewSale.getContentPane());
    transactionDialogNewSale.getContentPane().setLayout(transactionDialogNewSaleLayout);
    transactionDialogNewSaleLayout.setHorizontalGroup(
        transactionDialogNewSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(transactionDialogNewSalePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    transactionDialogNewSaleLayout.setVerticalGroup(
        transactionDialogNewSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(transactionDialogNewSalePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    accountDialogNew.setModal(true);
    accountDialogNew.setSize(new java.awt.Dimension(450, 450));

    createAccountPanel.setBackground(new java.awt.Color(33, 33, 33));

    accountDialogNewTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    accountDialogNewTitle.setForeground(new java.awt.Color(255, 255, 255));
    accountDialogNewTitle.setText("INGRESA LOS DATOS");

    accountDialogNewTitleCorreo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    accountDialogNewTitleCorreo.setForeground(new java.awt.Color(255, 255, 255));
    accountDialogNewTitleCorreo.setText("CORREO");

    accountDialogNewTitleLimit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    accountDialogNewTitleLimit.setForeground(new java.awt.Color(255, 255, 255));
    accountDialogNewTitleLimit.setText("LIMITE");

    accountDialogNewTitlePassword.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    accountDialogNewTitlePassword.setForeground(new java.awt.Color(255, 255, 255));
    accountDialogNewTitlePassword.setText("CONTRASEÑA");

    accountDialogNewCorreoLabel.setBackground(new java.awt.Color(33, 33, 33));
    accountDialogNewCorreoLabel.setForeground(new java.awt.Color(153, 153, 153));
    accountDialogNewCorreoLabel.setText("Ejemplo@gmail.com");
    accountDialogNewCorreoLabel.setBorder(null);
    accountDialogNewCorreoLabel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            accountDialogNewCorreoLabelActionPerformed(evt);
        }
    });

    accountDialogNewLimitLabel.setBackground(new java.awt.Color(33, 33, 33));
    accountDialogNewLimitLabel.setForeground(new java.awt.Color(153, 153, 153));
    accountDialogNewLimitLabel.setText("Saldo limite");
    accountDialogNewLimitLabel.setBorder(null);
    accountDialogNewLimitLabel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            accountDialogNewLimitLabelActionPerformed(evt);
        }
    });

    accountDialogNewCreateButton.setBackground(new java.awt.Color(81, 102, 138));
    accountDialogNewCreateButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    accountDialogNewCreateButton.setForeground(new java.awt.Color(255, 255, 255));
    accountDialogNewCreateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tick.png"))); // NOI18N
    accountDialogNewCreateButton.setText("CREAR CUENTA");
    accountDialogNewCreateButton.setBorder(null);
    accountDialogNewCreateButton.setBorderPainted(false);
    accountDialogNewCreateButton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            accountDialogNewCreateButtonMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            accountDialogNewCreateButtonMouseExited(evt);
        }
    });
    accountDialogNewCreateButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            accountDialogNewCreateButtonActionPerformed(evt);
        }
    });

    accountDialogNewPasswordLabel.setBackground(new java.awt.Color(33, 33, 33));
    accountDialogNewPasswordLabel.setForeground(new java.awt.Color(153, 153, 153));
    accountDialogNewPasswordLabel.setText("******************");
    accountDialogNewPasswordLabel.setBorder(null);
    accountDialogNewPasswordLabel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            accountDialogNewPasswordLabelActionPerformed(evt);
        }
    });

    jSeparator12.setForeground(new java.awt.Color(255, 255, 255));

    jSeparator13.setForeground(new java.awt.Color(255, 255, 255));

    jSeparator14.setForeground(new java.awt.Color(255, 255, 255));

    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 0, 0));

    javax.swing.GroupLayout createAccountPanelLayout = new javax.swing.GroupLayout(createAccountPanel);
    createAccountPanel.setLayout(createAccountPanelLayout);
    createAccountPanelLayout.setHorizontalGroup(
        createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(createAccountPanelLayout.createSequentialGroup()
            .addGap(66, 66, 66)
            .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(createAccountPanelLayout.createSequentialGroup()
                    .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(accountDialogNewPasswordLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                        .addComponent(jSeparator14, javax.swing.GroupLayout.Alignment.LEADING))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(createAccountPanelLayout.createSequentialGroup()
                    .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(accountDialogNewTitleCorreo)
                        .addComponent(accountDialogNewTitlePassword)
                        .addGroup(createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(accountDialogNewTitleLimit, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(accountDialogNewCorreoLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(jSeparator13)
                            .addComponent(accountDialogNewLimitLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(createAccountPanelLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(accountDialogNewTitle)))
                    .addGap(0, 64, Short.MAX_VALUE))))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createAccountPanelLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
        .addGroup(createAccountPanelLayout.createSequentialGroup()
            .addGap(109, 109, 109)
            .addComponent(accountDialogNewCreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    createAccountPanelLayout.setVerticalGroup(
        createAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createAccountPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(accountDialogNewTitle)
            .addGap(18, 18, 18)
            .addComponent(accountDialogNewTitleCorreo)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(accountDialogNewCorreoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(accountDialogNewTitleLimit)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(accountDialogNewLimitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(accountDialogNewTitlePassword)
            .addGap(16, 16, 16)
            .addComponent(accountDialogNewPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
            .addGap(18, 18, 18)
            .addComponent(accountDialogNewCreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(42, 42, 42))
    );

    javax.swing.GroupLayout accountDialogNewLayout = new javax.swing.GroupLayout(accountDialogNew.getContentPane());
    accountDialogNew.getContentPane().setLayout(accountDialogNewLayout);
    accountDialogNewLayout.setHorizontalGroup(
        accountDialogNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(createAccountPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    accountDialogNewLayout.setVerticalGroup(
        accountDialogNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(createAccountPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    transactionDialogSaleDetails.setTitle("Detalles de Venta");
    transactionDialogSaleDetails.setMinimumSize(new java.awt.Dimension(780, 550));
    transactionDialogSaleDetails.setModal(true);
    transactionDialogSaleDetails.setResizable(false);
    transactionDialogSaleDetails.setSize(new java.awt.Dimension(780, 550));

    transactionDialogSaleDetailsPanel.setBackground(new java.awt.Color(33, 33, 33));

    transactionDialogSaleDetailsPanel4.setBackground(new java.awt.Color(66, 66, 66));

    transactionDialogSaleDetailsLabelDetail.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
    transactionDialogSaleDetailsLabelDetail.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogSaleDetailsLabelDetail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    transactionDialogSaleDetailsLabelDetail.setText("DESCRIPCIÓN");
    transactionDialogSaleDetailsLabelDetail.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    transactionDialogSaleDetailsLabelDetail.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    transactionDialogSaleDetailsLabelDetail.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    javax.swing.GroupLayout transactionDialogSaleDetailsPanel4Layout = new javax.swing.GroupLayout(transactionDialogSaleDetailsPanel4);
    transactionDialogSaleDetailsPanel4.setLayout(transactionDialogSaleDetailsPanel4Layout);
    transactionDialogSaleDetailsPanel4Layout.setHorizontalGroup(
        transactionDialogSaleDetailsPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogSaleDetailsPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(transactionDialogSaleDetailsLabelDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );
    transactionDialogSaleDetailsPanel4Layout.setVerticalGroup(
        transactionDialogSaleDetailsPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogSaleDetailsPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(transactionDialogSaleDetailsLabelDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(18, Short.MAX_VALUE))
    );

    transactionDialogSaleDetailsLabelTitle.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
    transactionDialogSaleDetailsLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogSaleDetailsLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogSaleDetailsLabelTitle.setText("DETALLES DE LA VENTA");

    transactionDialogSaleDetailsPanel1.setBackground(new java.awt.Color(66, 66, 66));

    transactionDialogSaleDetailsLabelSaleId.setBackground(new java.awt.Color(255, 255, 255));
    transactionDialogSaleDetailsLabelSaleId.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogSaleDetailsLabelSaleId.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogSaleDetailsLabelSaleId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogSaleDetailsLabelSaleId.setText("01");

    transactionDialogSaleDetailsLabelSaleIdTitle.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogSaleDetailsLabelSaleIdTitle.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogSaleDetailsLabelSaleIdTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogSaleDetailsLabelSaleIdTitle.setText("ID DE VENTA :");

    transactionDialogSaleDetailsLabelAccountIdTitle.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogSaleDetailsLabelAccountIdTitle.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogSaleDetailsLabelAccountIdTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogSaleDetailsLabelAccountIdTitle.setText("ID DE CUENTA :");

    transactionDialogSaleDetailsLabelAccountId.setBackground(new java.awt.Color(255, 255, 255));
    transactionDialogSaleDetailsLabelAccountId.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogSaleDetailsLabelAccountId.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogSaleDetailsLabelAccountId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogSaleDetailsLabelAccountId.setText("01");

    transactionDialogSaleDetailsLabelStatusTitle.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogSaleDetailsLabelStatusTitle.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogSaleDetailsLabelStatusTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogSaleDetailsLabelStatusTitle.setText("CONFIRMADA :");

    transactionDialogSaleDetailsLabelStatus.setBackground(new java.awt.Color(255, 255, 255));
    transactionDialogSaleDetailsLabelStatus.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogSaleDetailsLabelStatus.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogSaleDetailsLabelStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogSaleDetailsLabelStatus.setText("SI");

    javax.swing.GroupLayout transactionDialogSaleDetailsPanel1Layout = new javax.swing.GroupLayout(transactionDialogSaleDetailsPanel1);
    transactionDialogSaleDetailsPanel1.setLayout(transactionDialogSaleDetailsPanel1Layout);
    transactionDialogSaleDetailsPanel1Layout.setHorizontalGroup(
        transactionDialogSaleDetailsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogSaleDetailsPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(transactionDialogSaleDetailsLabelSaleIdTitle)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(transactionDialogSaleDetailsLabelSaleId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(33, 33, 33)
            .addComponent(transactionDialogSaleDetailsLabelAccountIdTitle)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(transactionDialogSaleDetailsLabelAccountId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(transactionDialogSaleDetailsLabelStatusTitle)
            .addGap(18, 18, 18)
            .addComponent(transactionDialogSaleDetailsLabelStatus)
            .addGap(58, 58, 58))
    );
    transactionDialogSaleDetailsPanel1Layout.setVerticalGroup(
        transactionDialogSaleDetailsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogSaleDetailsPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(transactionDialogSaleDetailsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(transactionDialogSaleDetailsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transactionDialogSaleDetailsLabelStatusTitle)
                    .addComponent(transactionDialogSaleDetailsLabelStatus))
                .addGroup(transactionDialogSaleDetailsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transactionDialogSaleDetailsLabelAccountIdTitle)
                    .addComponent(transactionDialogSaleDetailsLabelAccountId))
                .addGroup(transactionDialogSaleDetailsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transactionDialogSaleDetailsLabelSaleIdTitle)
                    .addComponent(transactionDialogSaleDetailsLabelSaleId)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    transactionDialogSaleDetailsPanel2.setBackground(new java.awt.Color(66, 66, 66));

    transactionDialogSaleDetailsLabelCreated.setBackground(new java.awt.Color(255, 255, 255));
    transactionDialogSaleDetailsLabelCreated.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogSaleDetailsLabelCreated.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogSaleDetailsLabelCreated.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogSaleDetailsLabelCreated.setText("01/01/01 01:01:01");

    transactionDialogSaleDetailsLabelCreatedTitle.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogSaleDetailsLabelCreatedTitle.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogSaleDetailsLabelCreatedTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogSaleDetailsLabelCreatedTitle.setText("FECHA DE CREACIÓN :");

    javax.swing.GroupLayout transactionDialogSaleDetailsPanel2Layout = new javax.swing.GroupLayout(transactionDialogSaleDetailsPanel2);
    transactionDialogSaleDetailsPanel2.setLayout(transactionDialogSaleDetailsPanel2Layout);
    transactionDialogSaleDetailsPanel2Layout.setHorizontalGroup(
        transactionDialogSaleDetailsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogSaleDetailsPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(transactionDialogSaleDetailsLabelCreatedTitle)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
            .addComponent(transactionDialogSaleDetailsLabelCreated, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    transactionDialogSaleDetailsPanel2Layout.setVerticalGroup(
        transactionDialogSaleDetailsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogSaleDetailsPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(transactionDialogSaleDetailsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(transactionDialogSaleDetailsLabelCreatedTitle)
                .addComponent(transactionDialogSaleDetailsLabelCreated))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    transactionDialogSaleDetailsPanel3.setBackground(new java.awt.Color(66, 66, 66));

    transactionDialogSaleDetailsLabelUpdated.setBackground(new java.awt.Color(255, 255, 255));
    transactionDialogSaleDetailsLabelUpdated.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogSaleDetailsLabelUpdated.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogSaleDetailsLabelUpdated.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogSaleDetailsLabelUpdated.setText("01/01/01 01:01:01");

    transactionDialogSaleDetailsLabelUpdatedTitle.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogSaleDetailsLabelUpdatedTitle.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogSaleDetailsLabelUpdatedTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogSaleDetailsLabelUpdatedTitle.setText("FECHA DE ACTUALIZACIÓN :");

    javax.swing.GroupLayout transactionDialogSaleDetailsPanel3Layout = new javax.swing.GroupLayout(transactionDialogSaleDetailsPanel3);
    transactionDialogSaleDetailsPanel3.setLayout(transactionDialogSaleDetailsPanel3Layout);
    transactionDialogSaleDetailsPanel3Layout.setHorizontalGroup(
        transactionDialogSaleDetailsPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogSaleDetailsPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(transactionDialogSaleDetailsLabelUpdatedTitle)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(transactionDialogSaleDetailsLabelUpdated, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(26, 26, 26))
    );
    transactionDialogSaleDetailsPanel3Layout.setVerticalGroup(
        transactionDialogSaleDetailsPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogSaleDetailsPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(transactionDialogSaleDetailsPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(transactionDialogSaleDetailsLabelUpdatedTitle)
                .addComponent(transactionDialogSaleDetailsLabelUpdated))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    transactionDialogSaleDetailsLabelTotalAmountTitle.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
    transactionDialogSaleDetailsLabelTotalAmountTitle.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogSaleDetailsLabelTotalAmountTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogSaleDetailsLabelTotalAmountTitle.setText("MONTO TOTAL");

    transactionDialogSaleDetailsLabelDetailTitle.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
    transactionDialogSaleDetailsLabelDetailTitle.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogSaleDetailsLabelDetailTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogSaleDetailsLabelDetailTitle.setText("DESCRIPCIÓN");

    transactionDialogSaleDetailsLabelInitialPayTitle.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
    transactionDialogSaleDetailsLabelInitialPayTitle.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogSaleDetailsLabelInitialPayTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogSaleDetailsLabelInitialPayTitle.setText("PAGO INICIAL");

    transactionDialogSaleDetailsPanel5.setBackground(new java.awt.Color(66, 66, 66));

    transactionDialogSaleDetailsLabelNote1.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogSaleDetailsLabelNote1.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogSaleDetailsLabelNote1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    transactionDialogSaleDetailsLabelNote1.setText("$");
    transactionDialogSaleDetailsLabelNote1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    transactionDialogSaleDetailsLabelNote1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    transactionDialogSaleDetailsLabelInitialPay.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogSaleDetailsLabelInitialPay.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogSaleDetailsLabelInitialPay.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    transactionDialogSaleDetailsLabelInitialPay.setText("12345");
    transactionDialogSaleDetailsLabelInitialPay.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    transactionDialogSaleDetailsLabelInitialPay.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    javax.swing.GroupLayout transactionDialogSaleDetailsPanel5Layout = new javax.swing.GroupLayout(transactionDialogSaleDetailsPanel5);
    transactionDialogSaleDetailsPanel5.setLayout(transactionDialogSaleDetailsPanel5Layout);
    transactionDialogSaleDetailsPanel5Layout.setHorizontalGroup(
        transactionDialogSaleDetailsPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogSaleDetailsPanel5Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(transactionDialogSaleDetailsLabelNote1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(transactionDialogSaleDetailsLabelInitialPay, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(33, Short.MAX_VALUE))
    );
    transactionDialogSaleDetailsPanel5Layout.setVerticalGroup(
        transactionDialogSaleDetailsPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogSaleDetailsPanel5Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(transactionDialogSaleDetailsPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(transactionDialogSaleDetailsLabelInitialPay, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addComponent(transactionDialogSaleDetailsLabelNote1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
    );

    transactionDialogSaleDetailsPanel6.setBackground(new java.awt.Color(66, 66, 66));

    transactionDialogSaleDetailsLabelNote2.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogSaleDetailsLabelNote2.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogSaleDetailsLabelNote2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    transactionDialogSaleDetailsLabelNote2.setText("$");
    transactionDialogSaleDetailsLabelNote2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    transactionDialogSaleDetailsLabelNote2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    transactionDialogSaleDetailsLabelTotalAmount.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogSaleDetailsLabelTotalAmount.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogSaleDetailsLabelTotalAmount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    transactionDialogSaleDetailsLabelTotalAmount.setText("12345");
    transactionDialogSaleDetailsLabelTotalAmount.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    transactionDialogSaleDetailsLabelTotalAmount.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    javax.swing.GroupLayout transactionDialogSaleDetailsPanel6Layout = new javax.swing.GroupLayout(transactionDialogSaleDetailsPanel6);
    transactionDialogSaleDetailsPanel6.setLayout(transactionDialogSaleDetailsPanel6Layout);
    transactionDialogSaleDetailsPanel6Layout.setHorizontalGroup(
        transactionDialogSaleDetailsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogSaleDetailsPanel6Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(transactionDialogSaleDetailsLabelNote2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(transactionDialogSaleDetailsLabelTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(33, Short.MAX_VALUE))
    );
    transactionDialogSaleDetailsPanel6Layout.setVerticalGroup(
        transactionDialogSaleDetailsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogSaleDetailsPanel6Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(transactionDialogSaleDetailsPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(transactionDialogSaleDetailsLabelTotalAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addComponent(transactionDialogSaleDetailsLabelNote2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
    );

    transactionDialogSaleDetailsButtonBack.setBackground(new java.awt.Color(81, 102, 138));
    transactionDialogSaleDetailsButtonBack.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    transactionDialogSaleDetailsButtonBack.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogSaleDetailsButtonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go_back.png"))); // NOI18N
    transactionDialogSaleDetailsButtonBack.setText("VOLVER");
    transactionDialogSaleDetailsButtonBack.setBorder(null);
    transactionDialogSaleDetailsButtonBack.setBorderPainted(false);
    transactionDialogSaleDetailsButtonBack.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            transactionDialogSaleDetailsButtonBackMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            transactionDialogSaleDetailsButtonBackMouseExited(evt);
        }
    });
    transactionDialogSaleDetailsButtonBack.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            transactionDialogSaleDetailsButtonBackActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout transactionDialogSaleDetailsPanelLayout = new javax.swing.GroupLayout(transactionDialogSaleDetailsPanel);
    transactionDialogSaleDetailsPanel.setLayout(transactionDialogSaleDetailsPanelLayout);
    transactionDialogSaleDetailsPanelLayout.setHorizontalGroup(
        transactionDialogSaleDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogSaleDetailsPanelLayout.createSequentialGroup()
            .addGap(31, 31, 31)
            .addGroup(transactionDialogSaleDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(transactionDialogSaleDetailsPanelLayout.createSequentialGroup()
                    .addGroup(transactionDialogSaleDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(transactionDialogSaleDetailsLabelInitialPayTitle)
                        .addComponent(transactionDialogSaleDetailsPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(45, 45, 45)
                    .addGroup(transactionDialogSaleDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(transactionDialogSaleDetailsLabelTotalAmountTitle)
                        .addGroup(transactionDialogSaleDetailsPanelLayout.createSequentialGroup()
                            .addComponent(transactionDialogSaleDetailsPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(transactionDialogSaleDetailsButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(transactionDialogSaleDetailsPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(transactionDialogSaleDetailsLabelDetailTitle)
                .addComponent(transactionDialogSaleDetailsLabelTitle)
                .addComponent(transactionDialogSaleDetailsPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(transactionDialogSaleDetailsPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(transactionDialogSaleDetailsPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(49, Short.MAX_VALUE))
    );
    transactionDialogSaleDetailsPanelLayout.setVerticalGroup(
        transactionDialogSaleDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogSaleDetailsPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(transactionDialogSaleDetailsLabelTitle)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(transactionDialogSaleDetailsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(transactionDialogSaleDetailsPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(transactionDialogSaleDetailsPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(transactionDialogSaleDetailsLabelDetailTitle)
            .addGap(5, 5, 5)
            .addComponent(transactionDialogSaleDetailsPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(transactionDialogSaleDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(transactionDialogSaleDetailsPanelLayout.createSequentialGroup()
                    .addComponent(transactionDialogSaleDetailsLabelInitialPayTitle)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(transactionDialogSaleDetailsPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transactionDialogSaleDetailsPanelLayout.createSequentialGroup()
                    .addComponent(transactionDialogSaleDetailsLabelTotalAmountTitle)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(transactionDialogSaleDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(transactionDialogSaleDetailsPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transactionDialogSaleDetailsPanelLayout.createSequentialGroup()
                            .addComponent(transactionDialogSaleDetailsButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)))))
            .addContainerGap(18, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout transactionDialogSaleDetailsLayout = new javax.swing.GroupLayout(transactionDialogSaleDetails.getContentPane());
    transactionDialogSaleDetails.getContentPane().setLayout(transactionDialogSaleDetailsLayout);
    transactionDialogSaleDetailsLayout.setHorizontalGroup(
        transactionDialogSaleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(transactionDialogSaleDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    transactionDialogSaleDetailsLayout.setVerticalGroup(
        transactionDialogSaleDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(transactionDialogSaleDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    transactionDialogPaymentDetails.setTitle("Detalles de Pago");
    transactionDialogPaymentDetails.setMinimumSize(new java.awt.Dimension(800, 480));
    transactionDialogPaymentDetails.setModal(true);
    transactionDialogPaymentDetails.setResizable(false);
    transactionDialogPaymentDetails.setSize(new java.awt.Dimension(800, 480));

    transactionDialogPaymentDetailsPanel.setBackground(new java.awt.Color(33, 33, 33));

    transactionDialogPaymentDetailsLabelTitle.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
    transactionDialogPaymentDetailsLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogPaymentDetailsLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogPaymentDetailsLabelTitle.setText("DETALLES DEL PAGO");

    transactionDialogPaymentDetailsPanel1.setBackground(new java.awt.Color(66, 66, 66));

    transactionDialogPaymentDetailsLabelPaymentId.setBackground(new java.awt.Color(255, 255, 255));
    transactionDialogPaymentDetailsLabelPaymentId.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogPaymentDetailsLabelPaymentId.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogPaymentDetailsLabelPaymentId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogPaymentDetailsLabelPaymentId.setText("01");

    transactionDialogPaymentDetailsLabelPaymentIdTitle.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogPaymentDetailsLabelPaymentIdTitle.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogPaymentDetailsLabelPaymentIdTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogPaymentDetailsLabelPaymentIdTitle.setText("ID DE PAGO:");

    transactionDialogPaymentDetailsLabelAccountIdTitle.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogPaymentDetailsLabelAccountIdTitle.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogPaymentDetailsLabelAccountIdTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogPaymentDetailsLabelAccountIdTitle.setText("ID DE CUENTA :");

    transactionDialogPaymentDetailsLabelAccountId.setBackground(new java.awt.Color(255, 255, 255));
    transactionDialogPaymentDetailsLabelAccountId.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogPaymentDetailsLabelAccountId.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogPaymentDetailsLabelAccountId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogPaymentDetailsLabelAccountId.setText("01");

    transactionDialogPaymentDetailsLabelUserIdTitle.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogPaymentDetailsLabelUserIdTitle.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogPaymentDetailsLabelUserIdTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogPaymentDetailsLabelUserIdTitle.setText("ID DE USUARIO :");

    transactionDialogPaymentDetailsLabelUserId.setBackground(new java.awt.Color(255, 255, 255));
    transactionDialogPaymentDetailsLabelUserId.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogPaymentDetailsLabelUserId.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogPaymentDetailsLabelUserId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogPaymentDetailsLabelUserId.setText("01");

    javax.swing.GroupLayout transactionDialogPaymentDetailsPanel1Layout = new javax.swing.GroupLayout(transactionDialogPaymentDetailsPanel1);
    transactionDialogPaymentDetailsPanel1.setLayout(transactionDialogPaymentDetailsPanel1Layout);
    transactionDialogPaymentDetailsPanel1Layout.setHorizontalGroup(
        transactionDialogPaymentDetailsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogPaymentDetailsPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(transactionDialogPaymentDetailsLabelPaymentIdTitle)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(transactionDialogPaymentDetailsLabelPaymentId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(33, 33, 33)
            .addComponent(transactionDialogPaymentDetailsLabelAccountIdTitle)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(transactionDialogPaymentDetailsLabelAccountId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(transactionDialogPaymentDetailsLabelUserIdTitle)
            .addGap(29, 29, 29)
            .addComponent(transactionDialogPaymentDetailsLabelUserId)
            .addGap(47, 47, 47))
    );
    transactionDialogPaymentDetailsPanel1Layout.setVerticalGroup(
        transactionDialogPaymentDetailsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogPaymentDetailsPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(transactionDialogPaymentDetailsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(transactionDialogPaymentDetailsLabelPaymentIdTitle)
                .addComponent(transactionDialogPaymentDetailsLabelPaymentId)
                .addComponent(transactionDialogPaymentDetailsLabelAccountIdTitle)
                .addComponent(transactionDialogPaymentDetailsLabelAccountId)
                .addComponent(transactionDialogPaymentDetailsLabelUserIdTitle)
                .addComponent(transactionDialogPaymentDetailsLabelUserId))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    transactionDialogPaymentDetailsPanel2.setBackground(new java.awt.Color(66, 66, 66));

    transactionDialogPaymentDetailsLabelCreated.setBackground(new java.awt.Color(255, 255, 255));
    transactionDialogPaymentDetailsLabelCreated.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogPaymentDetailsLabelCreated.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogPaymentDetailsLabelCreated.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogPaymentDetailsLabelCreated.setText("01/01/01 01:01:01");

    transactionDialogPaymentDetailsLabelCreatedTitle.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogPaymentDetailsLabelCreatedTitle.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogPaymentDetailsLabelCreatedTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogPaymentDetailsLabelCreatedTitle.setText("FECHA DE CREACIÓN :");

    javax.swing.GroupLayout transactionDialogPaymentDetailsPanel2Layout = new javax.swing.GroupLayout(transactionDialogPaymentDetailsPanel2);
    transactionDialogPaymentDetailsPanel2.setLayout(transactionDialogPaymentDetailsPanel2Layout);
    transactionDialogPaymentDetailsPanel2Layout.setHorizontalGroup(
        transactionDialogPaymentDetailsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogPaymentDetailsPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(transactionDialogPaymentDetailsLabelCreatedTitle)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
            .addComponent(transactionDialogPaymentDetailsLabelCreated, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    transactionDialogPaymentDetailsPanel2Layout.setVerticalGroup(
        transactionDialogPaymentDetailsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogPaymentDetailsPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(transactionDialogPaymentDetailsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(transactionDialogPaymentDetailsLabelCreatedTitle)
                .addComponent(transactionDialogPaymentDetailsLabelCreated))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    transactionDialogPaymentDetailsPanel3.setBackground(new java.awt.Color(66, 66, 66));

    transactionDialogPaymentDetailsLabelUpdated.setBackground(new java.awt.Color(255, 255, 255));
    transactionDialogPaymentDetailsLabelUpdated.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogPaymentDetailsLabelUpdated.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogPaymentDetailsLabelUpdated.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogPaymentDetailsLabelUpdated.setText("01/01/01 01:01:01");

    transactionDialogPaymentDetailsLabelUpdatedTitle.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogPaymentDetailsLabelUpdatedTitle.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogPaymentDetailsLabelUpdatedTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogPaymentDetailsLabelUpdatedTitle.setText("FECHA DE ACTUALIZACIÓN :");

    javax.swing.GroupLayout transactionDialogPaymentDetailsPanel3Layout = new javax.swing.GroupLayout(transactionDialogPaymentDetailsPanel3);
    transactionDialogPaymentDetailsPanel3.setLayout(transactionDialogPaymentDetailsPanel3Layout);
    transactionDialogPaymentDetailsPanel3Layout.setHorizontalGroup(
        transactionDialogPaymentDetailsPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogPaymentDetailsPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(transactionDialogPaymentDetailsLabelUpdatedTitle)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(transactionDialogPaymentDetailsLabelUpdated, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(26, 26, 26))
    );
    transactionDialogPaymentDetailsPanel3Layout.setVerticalGroup(
        transactionDialogPaymentDetailsPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogPaymentDetailsPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(transactionDialogPaymentDetailsPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(transactionDialogPaymentDetailsLabelUpdatedTitle)
                .addComponent(transactionDialogPaymentDetailsLabelUpdated))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    transactionDialogPaymentDetailsLabelTotalAmountTitle.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
    transactionDialogPaymentDetailsLabelTotalAmountTitle.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogPaymentDetailsLabelTotalAmountTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogPaymentDetailsLabelTotalAmountTitle.setText("MONTO TOTAL");

    transactionDialogPaymentDetailsLabelStatusTitle.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
    transactionDialogPaymentDetailsLabelStatusTitle.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogPaymentDetailsLabelStatusTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionDialogPaymentDetailsLabelStatusTitle.setText("CONFIRMADO");

    transactionDialogPaymentDetailsPanel4.setBackground(new java.awt.Color(66, 66, 66));

    transactionDialogPaymentDetailsLabelStatus.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogPaymentDetailsLabelStatus.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogPaymentDetailsLabelStatus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    transactionDialogPaymentDetailsLabelStatus.setText("SI");
    transactionDialogPaymentDetailsLabelStatus.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    transactionDialogPaymentDetailsLabelStatus.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    javax.swing.GroupLayout transactionDialogPaymentDetailsPanel4Layout = new javax.swing.GroupLayout(transactionDialogPaymentDetailsPanel4);
    transactionDialogPaymentDetailsPanel4.setLayout(transactionDialogPaymentDetailsPanel4Layout);
    transactionDialogPaymentDetailsPanel4Layout.setHorizontalGroup(
        transactionDialogPaymentDetailsPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transactionDialogPaymentDetailsPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(transactionDialogPaymentDetailsLabelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
            .addContainerGap())
    );
    transactionDialogPaymentDetailsPanel4Layout.setVerticalGroup(
        transactionDialogPaymentDetailsPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transactionDialogPaymentDetailsPanel4Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(transactionDialogPaymentDetailsLabelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    transactionDialogPaymentDetailsPanel5.setBackground(new java.awt.Color(66, 66, 66));

    transactionDialogPaymentDetailsLabelNote1.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogPaymentDetailsLabelNote1.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogPaymentDetailsLabelNote1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    transactionDialogPaymentDetailsLabelNote1.setText("$");
    transactionDialogPaymentDetailsLabelNote1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    transactionDialogPaymentDetailsLabelNote1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    transactionDialogPaymentDetailsLabelTotalAmount.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
    transactionDialogPaymentDetailsLabelTotalAmount.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogPaymentDetailsLabelTotalAmount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    transactionDialogPaymentDetailsLabelTotalAmount.setText("12345");
    transactionDialogPaymentDetailsLabelTotalAmount.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    transactionDialogPaymentDetailsLabelTotalAmount.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    javax.swing.GroupLayout transactionDialogPaymentDetailsPanel5Layout = new javax.swing.GroupLayout(transactionDialogPaymentDetailsPanel5);
    transactionDialogPaymentDetailsPanel5.setLayout(transactionDialogPaymentDetailsPanel5Layout);
    transactionDialogPaymentDetailsPanel5Layout.setHorizontalGroup(
        transactionDialogPaymentDetailsPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogPaymentDetailsPanel5Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(transactionDialogPaymentDetailsLabelNote1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(transactionDialogPaymentDetailsLabelTotalAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
            .addContainerGap())
    );
    transactionDialogPaymentDetailsPanel5Layout.setVerticalGroup(
        transactionDialogPaymentDetailsPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogPaymentDetailsPanel5Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(transactionDialogPaymentDetailsPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(transactionDialogPaymentDetailsLabelTotalAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addComponent(transactionDialogPaymentDetailsLabelNote1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
    );

    transactionDialogPaymentDetailsButtonBack.setBackground(new java.awt.Color(81, 102, 138));
    transactionDialogPaymentDetailsButtonBack.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    transactionDialogPaymentDetailsButtonBack.setForeground(new java.awt.Color(255, 255, 255));
    transactionDialogPaymentDetailsButtonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go_back.png"))); // NOI18N
    transactionDialogPaymentDetailsButtonBack.setText("VOLVER");
    transactionDialogPaymentDetailsButtonBack.setBorder(null);
    transactionDialogPaymentDetailsButtonBack.setBorderPainted(false);
    transactionDialogPaymentDetailsButtonBack.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            transactionDialogPaymentDetailsButtonBackMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            transactionDialogPaymentDetailsButtonBackMouseExited(evt);
        }
    });
    transactionDialogPaymentDetailsButtonBack.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            transactionDialogPaymentDetailsButtonBackActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout transactionDialogPaymentDetailsPanelLayout = new javax.swing.GroupLayout(transactionDialogPaymentDetailsPanel);
    transactionDialogPaymentDetailsPanel.setLayout(transactionDialogPaymentDetailsPanelLayout);
    transactionDialogPaymentDetailsPanelLayout.setHorizontalGroup(
        transactionDialogPaymentDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogPaymentDetailsPanelLayout.createSequentialGroup()
            .addGap(31, 31, 31)
            .addGroup(transactionDialogPaymentDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(transactionDialogPaymentDetailsLabelTotalAmountTitle)
                .addGroup(transactionDialogPaymentDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(transactionDialogPaymentDetailsPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(transactionDialogPaymentDetailsLabelTitle)
                    .addComponent(transactionDialogPaymentDetailsPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transactionDialogPaymentDetailsPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transactionDialogPaymentDetailsLabelStatusTitle)
                    .addComponent(transactionDialogPaymentDetailsPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(transactionDialogPaymentDetailsPanelLayout.createSequentialGroup()
                        .addComponent(transactionDialogPaymentDetailsPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(transactionDialogPaymentDetailsButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap(69, Short.MAX_VALUE))
    );
    transactionDialogPaymentDetailsPanelLayout.setVerticalGroup(
        transactionDialogPaymentDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(transactionDialogPaymentDetailsPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(transactionDialogPaymentDetailsLabelTitle)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(transactionDialogPaymentDetailsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(transactionDialogPaymentDetailsPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(transactionDialogPaymentDetailsPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(transactionDialogPaymentDetailsLabelStatusTitle)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(transactionDialogPaymentDetailsPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(transactionDialogPaymentDetailsLabelTotalAmountTitle)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(transactionDialogPaymentDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(transactionDialogPaymentDetailsPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(transactionDialogPaymentDetailsButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(38, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout transactionDialogPaymentDetailsLayout = new javax.swing.GroupLayout(transactionDialogPaymentDetails.getContentPane());
    transactionDialogPaymentDetails.getContentPane().setLayout(transactionDialogPaymentDetailsLayout);
    transactionDialogPaymentDetailsLayout.setHorizontalGroup(
        transactionDialogPaymentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(transactionDialogPaymentDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    transactionDialogPaymentDetailsLayout.setVerticalGroup(
        transactionDialogPaymentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(transactionDialogPaymentDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    accountDialogDetails.setTitle("Detalles de Venta");
    accountDialogDetails.setMinimumSize(new java.awt.Dimension(780, 550));
    accountDialogDetails.setModal(true);
    accountDialogDetails.setResizable(false);
    accountDialogDetails.setSize(new java.awt.Dimension(780, 550));

    accountDetailsPanel.setBackground(new java.awt.Color(33, 33, 33));

    accountName.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
    accountName.setForeground(new java.awt.Color(255, 255, 255));
    accountName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    accountName.setText("Nombre");

    goBack.setBackground(new java.awt.Color(81, 102, 138));
    goBack.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    goBack.setForeground(new java.awt.Color(255, 255, 255));
    goBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go_back.png"))); // NOI18N
    goBack.setText("VOLVER");
    goBack.setBorder(null);
    goBack.setBorderPainted(false);
    goBack.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            goBackMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            goBackMouseExited(evt);
        }
    });
    goBack.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            goBackActionPerformed(evt);
        }
    });

    limitAmount.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
    limitAmount.setForeground(new java.awt.Color(100, 100, 100));
    limitAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    limitAmount.setText("/ 30000");

    priceSymbol.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
    priceSymbol.setForeground(new java.awt.Color(255, 255, 255));
    priceSymbol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    priceSymbol.setText("$");

    totalAmount.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
    totalAmount.setForeground(new java.awt.Color(255, 255, 255));
    totalAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    totalAmount.setText("18000");

    accountAddress.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 14)); // NOI18N
    accountAddress.setForeground(new java.awt.Color(255, 255, 255));
    accountAddress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    accountAddress.setText("Dirección");

    accountEmail.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 18)); // NOI18N
    accountEmail.setForeground(new java.awt.Color(100, 100, 100));
    accountEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    accountEmail.setText("Correo");

    transactionsLabel.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 14)); // NOI18N
    transactionsLabel.setForeground(new java.awt.Color(255, 255, 255));
    transactionsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    transactionsLabel.setText("Transacciones");

    accountDetailsDebtTransactions.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Hora", "Detalles", "Total"
        }
    ));
    jScrollPane1.setViewportView(accountDetailsDebtTransactions);

    javax.swing.GroupLayout accountDetailsPanelLayout = new javax.swing.GroupLayout(accountDetailsPanel);
    accountDetailsPanel.setLayout(accountDetailsPanelLayout);
    accountDetailsPanelLayout.setHorizontalGroup(
        accountDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(accountDetailsPanelLayout.createSequentialGroup()
            .addGap(31, 31, 31)
            .addGroup(accountDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(accountDetailsPanelLayout.createSequentialGroup()
                    .addGroup(accountDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(transactionsLabel)
                        .addComponent(accountAddress)
                        .addGroup(accountDetailsPanelLayout.createSequentialGroup()
                            .addComponent(priceSymbol)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(totalAmount)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(limitAmount))
                        .addGroup(accountDetailsPanelLayout.createSequentialGroup()
                            .addComponent(accountName)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(accountEmail)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(accountDetailsPanelLayout.createSequentialGroup()
                    .addGroup(accountDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, accountDetailsPanelLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(goBack, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(31, 31, 31))))
    );
    accountDetailsPanelLayout.setVerticalGroup(
        accountDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(accountDetailsPanelLayout.createSequentialGroup()
            .addGap(11, 11, 11)
            .addGroup(accountDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(accountName)
                .addComponent(accountEmail))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(accountDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(priceSymbol)
                .addComponent(limitAmount)
                .addComponent(totalAmount))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(accountAddress)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(transactionsLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(goBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(24, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout accountDialogDetailsLayout = new javax.swing.GroupLayout(accountDialogDetails.getContentPane());
    accountDialogDetails.getContentPane().setLayout(accountDialogDetailsLayout);
    accountDialogDetailsLayout.setHorizontalGroup(
        accountDialogDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(accountDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    accountDialogDetailsLayout.setVerticalGroup(
        accountDialogDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(accountDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Desktop App - Programación de Aplicaciones");
    setResizable(false);

    mainCards.setLayout(new java.awt.CardLayout());

    mainCard1.setBackground(new java.awt.Color(33, 33, 33));

    organizationLabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    organizationLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
    organizationLabelTitle.setText("TUS ORGANIZACIONES");

    organizationsTable.setBackground(new java.awt.Color(66, 66, 66));
    organizationsTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    organizationsTable.setForeground(new java.awt.Color(255, 255, 255));
    organizationsTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Id", "Nombre", "Descripcion"
        }
    ) {
        Class[] types = new Class [] {
            java.lang.Integer.class, java.lang.String.class, java.lang.String.class
        };
        boolean[] canEdit = new boolean [] {
            false, false, false
        };

        public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
        }

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    organizationsTable.setGridColor(new java.awt.Color(66, 66, 66));
    organizationsTable.getColumnModel().getColumn(0).setWidth(0);
    organizationsTable.getColumnModel().getColumn(0).setMinWidth(0);
    organizationsTable.getColumnModel().getColumn(0).setMaxWidth(0);
    organizationsTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            organizationsTableMouseClicked(evt);
        }
    });
    organizationScrollPaneTable.setViewportView(organizationsTable);
    if (organizationsTable.getColumnModel().getColumnCount() > 0) {
        organizationsTable.getColumnModel().getColumn(0).setResizable(false);
        organizationsTable.getColumnModel().getColumn(1).setResizable(false);
        organizationsTable.getColumnModel().getColumn(2).setResizable(false);
    }

    organizationLabelNote.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    organizationLabelNote.setForeground(new java.awt.Color(255, 255, 255));
    organizationLabelNote.setText("PRESIONA CLICK SOBRE UNA ORGANIZACIÓN PARA VER MÁS DETALLES");

    organizationButtonNewOrganization.setBackground(new java.awt.Color(81, 102, 138));
    organizationButtonNewOrganization.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
    organizationButtonNewOrganization.setForeground(new java.awt.Color(255, 255, 255));
    organizationButtonNewOrganization.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_org.png"))); // NOI18N
    organizationButtonNewOrganization.setText("CREAR ORGANIZACIÓN");
    organizationButtonNewOrganization.setBorder(null);
    organizationButtonNewOrganization.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            organizationButtonNewOrganizationMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            organizationButtonNewOrganizationMouseExited(evt);
        }
    });
    organizationButtonNewOrganization.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            organizationButtonNewOrganizationActionPerformed(evt);
        }
    });
    organizationButtonNewOrganization.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            organizationButtonNewOrganizationKeyPressed(evt);
        }
    });

    organizationButtonLogOff.setBackground(new java.awt.Color(81, 102, 138));
    organizationButtonLogOff.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
    organizationButtonLogOff.setForeground(new java.awt.Color(255, 255, 255));
    organizationButtonLogOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/poweroff.png"))); // NOI18N
    organizationButtonLogOff.setText("CERRAR SESIÓN");
    organizationButtonLogOff.setBorder(null);
    organizationButtonLogOff.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            organizationButtonLogOffMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            organizationButtonLogOffMouseExited(evt);
        }
    });
    organizationButtonLogOff.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            organizationButtonLogOffActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout mainCard1Layout = new javax.swing.GroupLayout(mainCard1);
    mainCard1.setLayout(mainCard1Layout);
    mainCard1Layout.setHorizontalGroup(
        mainCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(mainCard1Layout.createSequentialGroup()
            .addGap(22, 22, 22)
            .addGroup(mainCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainCard1Layout.createSequentialGroup()
                    .addGroup(mainCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(organizationLabelNote, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(organizationLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                    .addComponent(organizationButtonLogOff, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(organizationScrollPaneTable, javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(mainCard1Layout.createSequentialGroup()
                    .addComponent(organizationButtonNewOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGap(22, 22, 22))
    );
    mainCard1Layout.setVerticalGroup(
        mainCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(mainCard1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(mainCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(mainCard1Layout.createSequentialGroup()
                    .addComponent(organizationLabelTitle)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(organizationLabelNote))
                .addComponent(organizationButtonLogOff, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(organizationScrollPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(organizationButtonNewOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(13, 13, 13))
    );

    mainCards.add(mainCard1, "mainCard1");

    mainCard2.setLayout(new java.awt.CardLayout());

    jSplitPane1.setDividerSize(0);

    jPanelWithButtons.setBackground(new java.awt.Color(33, 33, 33));

    jPanel2.setBackground(new java.awt.Color(33, 33, 33));

    homeButtonDetails.setBackground(new java.awt.Color(81, 102, 138));
    homeButtonDetails.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
    homeButtonDetails.setForeground(new java.awt.Color(255, 255, 255));
    homeButtonDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_transaction2.png"))); // NOI18N
    homeButtonDetails.setText("DETALLES");
    homeButtonDetails.setBorder(null);
    homeButtonDetails.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            homeButtonDetailsMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            homeButtonDetailsMouseExited(evt);
        }
    });
    homeButtonDetails.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            homeButtonDetailsActionPerformed(evt);
        }
    });

    homeButtonTransactions.setBackground(new java.awt.Color(81, 102, 138));
    homeButtonTransactions.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
    homeButtonTransactions.setForeground(new java.awt.Color(255, 255, 255));
    homeButtonTransactions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/coins.png"))); // NOI18N
    homeButtonTransactions.setText("TRANSACCIONES");
    homeButtonTransactions.setBorder(null);
    homeButtonTransactions.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            homeButtonTransactionsMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            homeButtonTransactionsMouseExited(evt);
        }
    });
    homeButtonTransactions.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            homeButtonTransactionsActionPerformed(evt);
        }
    });

    homeLabelYourOrgName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    homeLabelYourOrgName.setForeground(new java.awt.Color(255, 255, 255));
    homeLabelYourOrgName.setText("TU ORGANIZACION");

    homeButtonBack.setBackground(new java.awt.Color(81, 102, 138));
    homeButtonBack.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
    homeButtonBack.setForeground(new java.awt.Color(255, 255, 255));
    homeButtonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/go_back.png"))); // NOI18N
    homeButtonBack.setText("VOLVER");
    homeButtonBack.setBorder(null);
    homeButtonBack.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            homeButtonBackMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            homeButtonBackMouseExited(evt);
        }
    });
    homeButtonBack.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            homeButtonBackActionPerformed(evt);
        }
    });

    homeButtonAccounts.setBackground(new java.awt.Color(81, 102, 138));
    homeButtonAccounts.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
    homeButtonAccounts.setForeground(new java.awt.Color(255, 255, 255));
    homeButtonAccounts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/group.png"))); // NOI18N
    homeButtonAccounts.setText("CUENTAS");
    homeButtonAccounts.setBorder(null);
    homeButtonAccounts.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            homeButtonAccountsMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            homeButtonAccountsMouseExited(evt);
        }
    });
    homeButtonAccounts.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            homeButtonAccountsActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(17, 17, 17)
            .addComponent(homeLabelYourOrgName)
            .addContainerGap(16, Short.MAX_VALUE))
        .addComponent(homeButtonTransactions, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(homeButtonAccounts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(homeButtonDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(homeButtonBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(17, 17, 17)
            .addComponent(homeLabelYourOrgName)
            .addGap(35, 35, 35)
            .addComponent(homeButtonDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(homeButtonAccounts, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(homeButtonTransactions, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 286, Short.MAX_VALUE)
            .addComponent(homeButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    jPanelWithButtons.add(jPanel2);

    jSplitPane1.setLeftComponent(jPanelWithButtons);

    panelCards.setLayout(new java.awt.CardLayout());

    panelCard1.setBackground(new java.awt.Color(33, 33, 33));

    jPanel4.setBackground(new java.awt.Color(66, 66, 66));

    homeDetailsLabelDetailTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    homeDetailsLabelDetailTitle.setForeground(new java.awt.Color(255, 255, 255));
    homeDetailsLabelDetailTitle.setText("DESCRIPCIÓN:");

    homeDetailsLabelDetail.setBackground(new java.awt.Color(255, 255, 255));
    homeDetailsLabelDetail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    homeDetailsLabelDetail.setForeground(new java.awt.Color(255, 255, 255));
    homeDetailsLabelDetail.setText("123");
    homeDetailsLabelDetail.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    homeDetailsLabelDetail.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    homeDetailsLabelDetail.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(homeDetailsLabelDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(homeDetailsLabelDetailTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(138, Short.MAX_VALUE))
    );
    jPanel4Layout.setVerticalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(homeDetailsLabelDetailTitle)
            .addGap(18, 18, 18)
            .addComponent(homeDetailsLabelDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(319, Short.MAX_VALUE))
    );

    organizationLabelTitle2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    organizationLabelTitle2.setForeground(new java.awt.Color(255, 255, 255));
    organizationLabelTitle2.setText("DETALLES");

    javax.swing.GroupLayout panelCard1Layout = new javax.swing.GroupLayout(panelCard1);
    panelCard1.setLayout(panelCard1Layout);
    panelCard1Layout.setHorizontalGroup(
        panelCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelCard1Layout.createSequentialGroup()
            .addGap(42, 42, 42)
            .addGroup(panelCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(organizationLabelTitle2)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(25, Short.MAX_VALUE))
    );
    panelCard1Layout.setVerticalGroup(
        panelCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCard1Layout.createSequentialGroup()
            .addGap(15, 15, 15)
            .addComponent(organizationLabelTitle2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(66, 66, 66))
    );

    panelCards.add(panelCard1, "panelCard1");

    panelCard2.setBackground(new java.awt.Color(33, 33, 33));

    jPanel6.setBackground(new java.awt.Color(66, 66, 66));

    homeAccountTable.setBackground(new java.awt.Color(66, 66, 66));
    homeAccountTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    homeAccountTable.setForeground(new java.awt.Color(255, 255, 255));
    homeAccountTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Id", "Nombre", "Total", "Límite"
        }
    ) {
        Class[] types = new Class [] {
            java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class
        };
        boolean[] canEdit = new boolean [] {
            true, false, false, false
        };

        public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
        }

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    homeAccountTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            homeAccountTableMouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(homeAccountTable);
    if (homeAccountTable.getColumnModel().getColumnCount() > 0) {
        homeAccountTable.getColumnModel().getColumn(1).setResizable(false);
        homeAccountTable.getColumnModel().getColumn(2).setResizable(false);
        homeAccountTable.getColumnModel().getColumn(3).setResizable(false);
    }
    //homeAccountTable.getColumnModel().getColumn(0).setWidth(0);
    //homeAccountTable.getColumnModel().getColumn(0).setMinWidth(0);
    //homeAccountTable.getColumnModel().getColumn(0).setMaxWidth(0);

    homeAccountLabelAccountAmountTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    homeAccountLabelAccountAmountTitle.setForeground(new java.awt.Color(255, 255, 255));
    homeAccountLabelAccountAmountTitle.setText("CANTIDAD DE CUENTAS :");

    homeAccountLabelAccountAmount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    homeAccountLabelAccountAmount.setForeground(new java.awt.Color(255, 255, 255));
    homeAccountLabelAccountAmount.setText("                                         ");

    homeAccountTextFieldSearch.setBackground(new java.awt.Color(66, 66, 66));
    homeAccountTextFieldSearch.setForeground(new java.awt.Color(255, 255, 255));
    homeAccountTextFieldSearch.addInputMethodListener(new java.awt.event.InputMethodListener() {
        public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
        }
        public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            homeAccountTextFieldSearchInputMethodTextChanged(evt);
        }
    });
    homeAccountTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            homeAccountTextFieldSearchKeyPressed(evt);
        }
        public void keyReleased(java.awt.event.KeyEvent evt) {
            homeAccountTextFieldSearchKeyReleased(evt);
        }
        public void keyTyped(java.awt.event.KeyEvent evt) {
            homeAccountTextFieldSearchKeyTyped(evt);
        }
    });

    homeAccountLabelSearchTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    homeAccountLabelSearchTitle.setForeground(new java.awt.Color(255, 255, 255));
    homeAccountLabelSearchTitle.setText("Buscar");

    javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
    jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(
        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel6Layout.createSequentialGroup()
            .addGap(21, 21, 21)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                    .addComponent(homeAccountLabelAccountAmountTitle)
                    .addGap(18, 18, 18)
                    .addComponent(homeAccountLabelAccountAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(89, 89, 89)
                    .addComponent(homeAccountLabelSearchTitle)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(homeAccountTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(135, Short.MAX_VALUE))
    );
    jPanel6Layout.setVerticalGroup(
        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel6Layout.createSequentialGroup()
            .addGap(13, 13, 13)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(homeAccountLabelAccountAmountTitle)
                .addComponent(homeAccountLabelAccountAmount)
                .addComponent(homeAccountLabelSearchTitle)
                .addComponent(homeAccountTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(11, Short.MAX_VALUE))
    );

    homeAccountButtonNewAccount.setBackground(new java.awt.Color(81, 102, 138));
    homeAccountButtonNewAccount.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
    homeAccountButtonNewAccount.setForeground(new java.awt.Color(255, 255, 255));
    homeAccountButtonNewAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add user 2.png"))); // NOI18N
    homeAccountButtonNewAccount.setText("CREAR CUENTA");
    homeAccountButtonNewAccount.setBorder(null);
    homeAccountButtonNewAccount.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            homeAccountButtonNewAccountMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            homeAccountButtonNewAccountMouseExited(evt);
        }
    });
    homeAccountButtonNewAccount.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            homeAccountButtonNewAccountActionPerformed(evt);
        }
    });

    homeAccountButtonUpdateAccount.setBackground(new java.awt.Color(81, 102, 138));
    homeAccountButtonUpdateAccount.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
    homeAccountButtonUpdateAccount.setForeground(new java.awt.Color(255, 255, 255));
    homeAccountButtonUpdateAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_page.png"))); // NOI18N
    homeAccountButtonUpdateAccount.setText("MODIFICAR CUENTA");
    homeAccountButtonUpdateAccount.setBorder(null);
    homeAccountButtonUpdateAccount.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            homeAccountButtonUpdateAccountMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            homeAccountButtonUpdateAccountMouseExited(evt);
        }
    });
    homeAccountButtonUpdateAccount.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            homeAccountButtonUpdateAccountActionPerformed(evt);
        }
    });

    homeAccountLabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    homeAccountLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
    homeAccountLabelTitle.setText("LISTADO DE CUENTAS");

    javax.swing.GroupLayout panelCard2Layout = new javax.swing.GroupLayout(panelCard2);
    panelCard2.setLayout(panelCard2Layout);
    panelCard2Layout.setHorizontalGroup(
        panelCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelCard2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelCard2Layout.createSequentialGroup()
                    .addComponent(homeAccountButtonNewAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(homeAccountButtonUpdateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(homeAccountLabelTitle))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    panelCard2Layout.setVerticalGroup(
        panelCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCard2Layout.createSequentialGroup()
            .addGap(17, 17, 17)
            .addComponent(homeAccountLabelTitle)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
            .addGroup(panelCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(homeAccountButtonNewAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(homeAccountButtonUpdateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(15, 15, 15))
    );

    panelCards.add(panelCard2, "panelCard2");

    panelCard3.setBackground(new java.awt.Color(33, 33, 33));

    jPanel7.setBackground(new java.awt.Color(66, 66, 66));

    homeTransactionLabelSaleTitle.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
    homeTransactionLabelSaleTitle.setForeground(new java.awt.Color(255, 255, 255));
    homeTransactionLabelSaleTitle.setText("VENTAS");

    homeTransactionLabelPaymentTitle.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
    homeTransactionLabelPaymentTitle.setForeground(new java.awt.Color(255, 255, 255));
    homeTransactionLabelPaymentTitle.setText("PAGOS");

    homeTransactionSaleTable.setBackground(new java.awt.Color(66, 66, 66));
    homeTransactionSaleTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    homeTransactionSaleTable.setForeground(new java.awt.Color(255, 255, 255));
    homeTransactionSaleTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Id", "Total", "Pago inicial", "Descripción"
        }
    ) {
        Class[] types = new Class [] {
            java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class
        };
        boolean[] canEdit = new boolean [] {
            false, false, false, false
        };

        public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
        }

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    homeTransactionSaleTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            homeTransactionSaleTableMouseClicked(evt);
        }
    });
    jScrollPane3.setViewportView(homeTransactionSaleTable);
    homeTransactionSaleTable.getColumnModel().getColumn(0).setWidth(0);
    homeTransactionSaleTable.getColumnModel().getColumn(0).setMinWidth(0);
    homeTransactionSaleTable.getColumnModel().getColumn(0).setMaxWidth(0);
    if (homeTransactionSaleTable.getColumnModel().getColumnCount() > 0) {
        homeTransactionSaleTable.getColumnModel().getColumn(0).setResizable(false);
        homeTransactionSaleTable.getColumnModel().getColumn(1).setResizable(false);
        homeTransactionSaleTable.getColumnModel().getColumn(2).setResizable(false);
        homeTransactionSaleTable.getColumnModel().getColumn(3).setResizable(false);
    }

    homeTransactionPaymentTable.setBackground(new java.awt.Color(66, 66, 66));
    homeTransactionPaymentTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
    homeTransactionPaymentTable.setForeground(new java.awt.Color(255, 255, 255));
    homeTransactionPaymentTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Id", "Total", "Estado"
        }
    ) {
        Class[] types = new Class [] {
            java.lang.Integer.class, java.lang.Float.class, java.lang.String.class
        };
        boolean[] canEdit = new boolean [] {
            false, false, false
        };

        public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
        }

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    homeTransactionPaymentTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            homeTransactionPaymentTableMouseClicked(evt);
        }
    });
    jScrollPane4.setViewportView(homeTransactionPaymentTable);
    homeTransactionPaymentTable.getColumnModel().getColumn(0).setWidth(0);
    homeTransactionPaymentTable.getColumnModel().getColumn(0).setMinWidth(0);
    homeTransactionPaymentTable.getColumnModel().getColumn(0).setMaxWidth(0);
    if (homeTransactionPaymentTable.getColumnModel().getColumnCount() > 0) {
        homeTransactionPaymentTable.getColumnModel().getColumn(0).setResizable(false);
        homeTransactionPaymentTable.getColumnModel().getColumn(1).setResizable(false);
        homeTransactionPaymentTable.getColumnModel().getColumn(2).setResizable(false);
    }

    javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
    jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(
        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel7Layout.createSequentialGroup()
            .addGap(126, 126, 126)
            .addComponent(homeTransactionLabelSaleTitle)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
            .addComponent(homeTransactionLabelPaymentTitle)
            .addGap(112, 112, 112))
        .addGroup(jPanel7Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );
    jPanel7Layout.setVerticalGroup(
        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel7Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(homeTransactionLabelSaleTitle)
                .addComponent(homeTransactionLabelPaymentTitle))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addComponent(jScrollPane4))
            .addContainerGap())
    );

    homeTransactionButtonNewTransaction.setBackground(new java.awt.Color(81, 102, 138));
    homeTransactionButtonNewTransaction.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
    homeTransactionButtonNewTransaction.setForeground(new java.awt.Color(255, 255, 255));
    homeTransactionButtonNewTransaction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit-cash.png"))); // NOI18N
    homeTransactionButtonNewTransaction.setText("NUEVA TRANSACCIÓN");
    homeTransactionButtonNewTransaction.setBorder(null);
    homeTransactionButtonNewTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            homeTransactionButtonNewTransactionMouseEntered(evt);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            homeTransactionButtonNewTransactionMouseExited(evt);
        }
    });
    homeTransactionButtonNewTransaction.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            homeTransactionButtonNewTransactionActionPerformed(evt);
        }
    });

    homeTransactionLabelTitle.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
    homeTransactionLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
    homeTransactionLabelTitle.setText("CLICKEA UNA TRANSACCIÓN PARA VER MAS DETALLES");

    organizationLabelTitle1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    organizationLabelTitle1.setForeground(new java.awt.Color(255, 255, 255));
    organizationLabelTitle1.setText("LISTA DE TRANSACCIONES");

    javax.swing.GroupLayout panelCard3Layout = new javax.swing.GroupLayout(panelCard3);
    panelCard3.setLayout(panelCard3Layout);
    panelCard3Layout.setHorizontalGroup(
        panelCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelCard3Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelCard3Layout.createSequentialGroup()
                    .addGroup(panelCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(homeTransactionLabelTitle)
                        .addComponent(organizationLabelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(homeTransactionButtonNewTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
    );
    panelCard3Layout.setVerticalGroup(
        panelCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCard3Layout.createSequentialGroup()
            .addGap(11, 11, 11)
            .addComponent(organizationLabelTitle1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(homeTransactionLabelTitle)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(homeTransactionButtonNewTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(17, Short.MAX_VALUE))
    );

    panelCards.add(panelCard3, "panelCard3");

    jSplitPane1.setRightComponent(panelCards);

    mainCard2.add(jSplitPane1, "mainCard2");

    mainCards.add(mainCard2, "mainCard2");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 810, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainCards, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 610, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

 
    
    private void homeButtonDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonDetailsActionPerformed
       // this.jButtonNewTransaction.setVisible(false);
        //this.jButtonAssignTransaction.setVisible(false);
        
        cardLayout.show(panelCards,"panelCard1");
    }//GEN-LAST:event_homeButtonDetailsActionPerformed

    private void homeButtonAccountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonAccountsActionPerformed
        //this.jButtonNewTransaction.setVisible(false);
        //this.jButtonAssignTransaction.setVisible(false);
        
        cardLayout.show(panelCards,"panelCard2");
    }//GEN-LAST:event_homeButtonAccountsActionPerformed

    private void homeButtonTransactionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonTransactionsActionPerformed
        this.homeTransactionButtonNewTransaction.setVisible(true);
        cardLayout.show(panelCards,"panelCard3");
    }//GEN-LAST:event_homeButtonTransactionsActionPerformed

    private void homeButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonBackActionPerformed
        //this.jButtonAssignTransaction.setVisible(false);
       // this.jButtonNewTransaction.setVisible(false);
        mainLayout.show(mainCards, "mainCard1");
    }//GEN-LAST:event_homeButtonBackActionPerformed

    private void organizationsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_organizationsTableMouseClicked

        int selectedRow = organizationsTable.getSelectedRow();
        int orgId = (int) organizationsTable.getValueAt(selectedRow,0);
        String name = (String) organizationsTable.getValueAt(selectedRow, 1);
        String desc = (String) organizationsTable.getValueAt(selectedRow, 2);
        
        resetAccountTable();
        loadAccountsOnTable(orgId);
        //falta cargar las transacciones
        
        resetTransactionTable();
        
        loadDebtTransactionsOnTable(orgId);
        
        loadPaymentTransactionsOnTable(orgId);
        
        this.organizationId = orgId;
        
        homeLabelYourOrgName.setText(name);    
        
        homeDetailsLabelDetail.setText(desc);
        
        mainLayout.show (mainCards, "mainCard2");
        cardLayout.show (panelCards,"panelCard1");
    }//GEN-LAST:event_organizationsTableMouseClicked

           
    
    private void organizationButtonNewOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationButtonNewOrganizationActionPerformed
        
        this.resetDialog();
        this.organizationDialogNewOrganization.setLocationRelativeTo(this);
        this.organizationDialogNewOrganization.setVisible(true);
        
        //createOrganizations create = new createOrganizations();
        //create.setVisible(true);
    }//GEN-LAST:event_organizationButtonNewOrganizationActionPerformed

    private void organizationButtonLogOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationButtonLogOffActionPerformed
        this.ICA = Factory.getInstance().getAuthController();
        this.ICA.logOut();
        this.dispose();
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_organizationButtonLogOffActionPerformed

    
    private void organizationDialogButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationDialogButtonAddActionPerformed
        this.jLabel2.setVisible(false);
        
        String name = organizationDialogTextFieldName.getText();
        String description = organizationDialogTextFieldDetail.getText();
        String password = organizationDialogTextFieldPassword.getText();
        String address = addressTextField.getText();
        boolean isPublic = organizationDialogPublicCheckBox.getHideActionText();
        
        Object selectedCityObj = this.jComboBoxAddressOrganization.getSelectedItem();
        String city = selectedCityObj.toString();
        
        boolean isChecked = organizationDialogPublicCheckBox.isSelected();
        if (isChecked)
            isPublic = true; 
        if (name.isEmpty() || password.isEmpty() || address.isEmpty()) {
            this.jLabel2.setVisible(true);
            this.jLabel2.setText("Completa todos los campos");
        }        
        else{       
            String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            this.ICO.createOrganizaation(name, description, isPublic, encryptedPassword, city, address); 
            this.resetTable();
            this.loadOrganizationsOnTable();
            this.organizationDialogNewOrganization.dispose();
        }
    }//GEN-LAST:event_organizationDialogButtonAddActionPerformed

    private void organizationDialogPublicCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationDialogPublicCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_organizationDialogPublicCheckBoxActionPerformed

    
    private void homeTransactionButtonNewTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeTransactionButtonNewTransactionActionPerformed
        this.loadOrganizationAccounts();
        this.transactionDialogOptions.setLocationRelativeTo(this);
        this.transactionDialogOptions.setVisible(true);
    }//GEN-LAST:event_homeTransactionButtonNewTransactionActionPerformed

    private void transactionDialogOptionButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionDialogOptionButtonBackActionPerformed
        this.transactionDialogOptions.setVisible(false);
    }//GEN-LAST:event_transactionDialogOptionButtonBackActionPerformed

    private void transactionDialogOptionsButtonPaymentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionDialogOptionsButtonPaymentMouseEntered
       this.transactionDialogOptionsButtonPayment.setBackground(mouseEntered);
    }//GEN-LAST:event_transactionDialogOptionsButtonPaymentMouseEntered

    private void transactionDialogOptionsButtonPaymentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionDialogOptionsButtonPaymentMouseExited
       this.transactionDialogOptionsButtonPayment.setBackground(mouseExited); 
    }//GEN-LAST:event_transactionDialogOptionsButtonPaymentMouseExited

    private void transactionDialogOptionsButtonPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionDialogOptionsButtonPaymentActionPerformed
        // -- Select Pago --
        
        this.transactionDialogOptions.setVisible(false);
        this.transactionDialogNewPay.setLocationRelativeTo(this);
        resetDialog();
        this.transactionDialogNewPay.setVisible(true);
    }//GEN-LAST:event_transactionDialogOptionsButtonPaymentActionPerformed

    private void transactionDialogNewPayButtonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionDialogNewPayButtonCreateActionPerformed
        // -- Crear transacción de Pago --
        
        this.jLabel4.setVisible(false);
        String accountId = null;
        int organizationId = this.organizationId;
        String organizationName = null;
        String userId;
                
        String status = "confirmed";
        String amount = transactionDialogNewPayLabelTotalAmount.getText();
        
        Object selectedEmailObj = this.transactionDialogNewPayComboBox.getSelectedItem();
        String email = selectedEmailObj.toString();
        
        this.organization = this.ICO.getOrganizationById(organizationId+"");
        organizationName = this.organization.getName();
        
        userId = this.ICU.getUserIdByEmail(email)+"";
        
        for(AccountUser accountUser : this.accountsInfo) {
            if(accountUser.getUser().getEmail() == email) {
                accountId = "" + accountUser.getAccount().getAttributes().getId();
            }
        }
        
         boolean flag = false;
        try{
            int k = Integer.parseInt(amount);
        } catch(NumberFormatException e){
            this.jLabel4.setVisible(true);
            this.jLabel4.setText("Valor incorrcto");
            flag = true;            
        }           
        if (amount.isEmpty()) {
            this.jLabel4.setVisible(true);
            this.jLabel4.setText("Completa todos los campos");        
            flag = true;       
        }
               
        if(flag == false){         
            this.ICT.createPaymentTransaction(status, accountId, amount, userId);
            this.IEC.sendTransactionPayNotificationMessage(email, status, amount, organizationName);
            this.transactionDialogNewPay.setVisible(false);
            reloadTransactionTable(this.organizationId);
            //restar pago al total de la cuenta
            //update total de cuenta
            
            Float totalSubtractDebt = Float.valueOf(amount);
            
            
            
            Float totalDeudaActual = this.ICAccount.getAccountTotalAmount(accountId);
            
            Float totalUpdatedDebt = totalDeudaActual - totalSubtractDebt;
            
            this.ICAccount.setAccountNewTotalAmount(accountId,totalUpdatedDebt);
            
            this.resetAccountTable();
            this.reloadAccountTable(this.organizationId);
            
            
            
        }      
    }//GEN-LAST:event_transactionDialogNewPayButtonCreateActionPerformed

    private void transactionDialogNewSaleLabelDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionDialogNewSaleLabelDetailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transactionDialogNewSaleLabelDetailActionPerformed

     public void loadOrganizationAccounts() {
        this.ICO = Factory.getInstance().getOrganizationController();
        this.IEC = Factory.getInstance().getEmailController();
        
        String organiationId = this.organizationId + "";
        
        this.accountsInfo = this.ICO.getAccountAndUserDetails(organiationId);
        String[] accountsEmails = new String[accountsInfo.size()];

        for (int k = 0; k < this.accountsInfo.size(); k++) {
            accountsEmails[k] = this.accountsInfo.get(k).getUser().getEmail();
        }
        // this.IEmail.sendTransactionVerificationMessage("super3millucas@gmail.com");
        this.jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(accountsEmails));
        this.transactionDialogNewPayComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(accountsEmails));
    }
     
    
    private void transactionDialogNewSaleButtonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionDialogNewSaleButtonCreateActionPerformed
        // -- Crear transacción de Deuda --
        int organizaionId = this.organizationId;       
        String AccountId = null;
        String organizationName = null;
             
        this.jLabel3.setVisible(false);
        
        String detail = transactionDialogNewSaleLabelDetail.getText();
        String initialPayment = transactionDialogNewSaleLabelInitialPayment.getText();
        String initialAmount = transactionDialogNewSaleTotalAmount.getText();
        
        Object selectedEmailObj = this.jComboBox1.getSelectedItem();
        String email = selectedEmailObj.toString();
        
        this.organization = this.ICO.getOrganizationById(organizationId+"");
        organizationName = this.organization.getName();
        
        for(AccountUser accountUser : this.accountsInfo) {
            if(accountUser.getUser().getEmail() == email) {
                AccountId = "" + accountUser.getAccount().getAttributes().getId();
            }
        }
        
        boolean flag = false;
        try{
            int k = Integer.parseInt(initialPayment);//parseInt o parseUnsignedInt? hay que leer lo que devuelven porque me parece que estos campos no pueden ser negativos ni van a tener un "+"
            int j = Integer.parseInt(initialAmount);
            
            
            Integer integerInitialPayment = Integer.valueOf(initialPayment);
            Integer integerInitialAmount = Integer.valueOf(initialAmount);
            
            if (integerInitialPayment > integerInitialAmount){
            this.jLabel3.setVisible(true);
            this.jLabel3.setText("El pago inicial no puede ser mayor al total");
            flag = true;
        }
            
        } catch(NumberFormatException e){
            this.jLabel3.setVisible(true);
            this.jLabel3.setText("Valor incorrecto");
            flag = true;            
        }           
        
        if (initialPayment.isEmpty() || initialAmount.isEmpty()) {
            this.jLabel3.setVisible(true);
            this.jLabel3.setText("Completa todos los campos");        
            flag = true;       
        }
        
        
        
        if(flag == false){
            Integer returnedTransactionId = this.ICT.createDebtTransaction(AccountId, detail, initialPayment, initialAmount);
            
            this.IEC.sendTransactionVerificationMessage(email, detail, initialPayment, initialAmount, organizationName, "" + returnedTransactionId);
            this.transactionDialogNewSale.setVisible(false);
            this.reloadTransactionTable(this.organizationId);   
            //update total de cuenta
            
            Float floatInitialPayment = Float.parseFloat(initialPayment);
            Float floatInitialAmount = Float.parseFloat(initialAmount);
            
            Float totalAddDebt = floatInitialAmount - floatInitialPayment;
            Float totalActualDebt = this.ICAccount.getAccountTotalAmount(AccountId);
                        
            Float totalUpdatedDebt = totalActualDebt + totalAddDebt;
            
            this.ICAccount.setAccountNewTotalAmount(AccountId,totalUpdatedDebt);
            
            this.resetAccountTable();
            this.reloadAccountTable(this.organizationId);
            
            //   
        }    
    }//GEN-LAST:event_transactionDialogNewSaleButtonCreateActionPerformed

    private void transactionDialogNewSaleLabelInitialPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionDialogNewSaleLabelInitialPaymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transactionDialogNewSaleLabelInitialPaymentActionPerformed

    private void transactionDialogNewSaleTotalAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionDialogNewSaleTotalAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transactionDialogNewSaleTotalAmountActionPerformed

    private void transactionDialogOptionsButtonSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionDialogOptionsButtonSaleActionPerformed
        // -- Select Venta --
        
        this.transactionDialogOptions.setVisible(false);
        this.transactionDialogNewSale.setLocationRelativeTo(this);
        resetDialog();
        this.transactionDialogNewSale.setVisible(true);
    }//GEN-LAST:event_transactionDialogOptionsButtonSaleActionPerformed

    private void homeAccountButtonNewAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeAccountButtonNewAccountActionPerformed
      this.accountDialogNew.setLocationRelativeTo(this);
      this.accountDialogNew.setVisible(true);
    }//GEN-LAST:event_homeAccountButtonNewAccountActionPerformed

    private void homeAccountButtonUpdateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeAccountButtonUpdateAccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homeAccountButtonUpdateAccountActionPerformed

    private void organizationDialogTextFieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationDialogTextFieldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_organizationDialogTextFieldPasswordActionPerformed

    private void organizationDialogTextFieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationDialogTextFieldNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_organizationDialogTextFieldNameActionPerformed

    private void homeTransactionSaleTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeTransactionSaleTableMouseClicked
        // -- Mostrar detalles de Transacción de Venta -- 
        int selectedRow = homeTransactionSaleTable.getSelectedRow();
        int transactionId = (int) homeTransactionSaleTable.getValueAt(selectedRow,0);
        
        //cargar dialog con detalles de transacción de venta
        loadDebtTransactionDetails(transactionId);
        
        this.transactionDialogSaleDetails.setLocationRelativeTo(this);
        this.transactionDialogSaleDetails.setVisible(true);
    }//GEN-LAST:event_homeTransactionSaleTableMouseClicked

    private void transactionDialogSaleDetailsButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionDialogSaleDetailsButtonBackActionPerformed
        this.transactionDialogSaleDetails.setVisible(false);
    }//GEN-LAST:event_transactionDialogSaleDetailsButtonBackActionPerformed

    private void homeTransactionPaymentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeTransactionPaymentTableMouseClicked
        // -- Mostrar detalles de Transacción de Pago -- 
        int selectedRow = homeTransactionPaymentTable.getSelectedRow();
        int transactionId = (int) homeTransactionPaymentTable.getValueAt(selectedRow,0);
        //cargar dialog con detalles de transacción de pago
        loadPaymentTransactionDetails(transactionId);
        
        this.transactionDialogPaymentDetails.setLocationRelativeTo(this);
        this.transactionDialogPaymentDetails.setVisible(true);
    }//GEN-LAST:event_homeTransactionPaymentTableMouseClicked

    private void transactionDialogPaymentDetailsButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionDialogPaymentDetailsButtonBackActionPerformed
         this.transactionDialogPaymentDetails.setVisible(false);
    }//GEN-LAST:event_transactionDialogPaymentDetailsButtonBackActionPerformed

    private void homeAccountTextFieldSearchInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_homeAccountTextFieldSearchInputMethodTextChanged
       
    }//GEN-LAST:event_homeAccountTextFieldSearchInputMethodTextChanged

    private void homeAccountTextFieldSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_homeAccountTextFieldSearchKeyPressed
        
    }//GEN-LAST:event_homeAccountTextFieldSearchKeyPressed

    private void homeAccountTextFieldSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_homeAccountTextFieldSearchKeyTyped
    }//GEN-LAST:event_homeAccountTextFieldSearchKeyTyped

    private void homeAccountTextFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_homeAccountTextFieldSearchKeyReleased
        String searchedText = this.homeAccountTextFieldSearch.getText();
        this.searchRowInTable(searchedText);
    }//GEN-LAST:event_homeAccountTextFieldSearchKeyReleased

    private void accountDialogNewCorreoLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountDialogNewCorreoLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountDialogNewCorreoLabelActionPerformed

    private void accountDialogNewLimitLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountDialogNewLimitLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountDialogNewLimitLabelActionPerformed

    private void accountDialogNewCreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountDialogNewCreateButtonActionPerformed
        createAccount();
        resetAccountTable();
        reloadAccountTable(this.organizationId);
    }//GEN-LAST:event_accountDialogNewCreateButtonActionPerformed

    private void accountDialogNewPasswordLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountDialogNewPasswordLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountDialogNewPasswordLabelActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void organizationButtonNewOrganizationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_organizationButtonNewOrganizationMouseEntered
        this.organizationButtonNewOrganization.setBackground(mouseEntered);
    }//GEN-LAST:event_organizationButtonNewOrganizationMouseEntered

    private void organizationButtonNewOrganizationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_organizationButtonNewOrganizationMouseExited
        this.organizationButtonNewOrganization.setBackground(mouseExited);
    }//GEN-LAST:event_organizationButtonNewOrganizationMouseExited

    private void organizationButtonLogOffMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_organizationButtonLogOffMouseEntered
        this.organizationButtonLogOff.setBackground(mouseEntered);
    }//GEN-LAST:event_organizationButtonLogOffMouseEntered

    private void organizationButtonLogOffMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_organizationButtonLogOffMouseExited
         this.organizationButtonLogOff.setBackground(mouseExited);
    }//GEN-LAST:event_organizationButtonLogOffMouseExited

    private void organizationButtonNewOrganizationKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_organizationButtonNewOrganizationKeyPressed
        
    }//GEN-LAST:event_organizationButtonNewOrganizationKeyPressed

    private void organizationDialogButtonAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_organizationDialogButtonAddMouseEntered
       this.organizationDialogButtonAdd.setBackground(mouseEntered);
    }//GEN-LAST:event_organizationDialogButtonAddMouseEntered

    private void organizationDialogButtonAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_organizationDialogButtonAddMouseExited
       this.organizationDialogButtonAdd.setBackground(mouseExited);
    }//GEN-LAST:event_organizationDialogButtonAddMouseExited

    private void homeButtonDetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonDetailsMouseEntered
       this.homeButtonDetails.setBackground(mouseEntered);
    }//GEN-LAST:event_homeButtonDetailsMouseEntered

    private void homeButtonDetailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonDetailsMouseExited
        this.homeButtonDetails.setBackground(mouseExited);
    }//GEN-LAST:event_homeButtonDetailsMouseExited

    private void homeButtonAccountsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonAccountsMouseEntered
       this.homeButtonAccounts.setBackground(mouseEntered);
    }//GEN-LAST:event_homeButtonAccountsMouseEntered

    private void homeButtonAccountsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonAccountsMouseExited
          this.homeButtonAccounts.setBackground(mouseExited);
    }//GEN-LAST:event_homeButtonAccountsMouseExited

    private void homeButtonTransactionsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonTransactionsMouseEntered
        this.homeButtonTransactions.setBackground(mouseEntered);
    }//GEN-LAST:event_homeButtonTransactionsMouseEntered

    private void homeButtonTransactionsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonTransactionsMouseExited
        this.homeButtonTransactions.setBackground(mouseExited);
    }//GEN-LAST:event_homeButtonTransactionsMouseExited

    private void homeButtonBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonBackMouseEntered
       this.homeButtonBack.setBackground(mouseEntered);
    }//GEN-LAST:event_homeButtonBackMouseEntered

    private void homeButtonBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonBackMouseExited
         this.homeButtonBack.setBackground(mouseExited);
    }//GEN-LAST:event_homeButtonBackMouseExited

    private void homeAccountButtonNewAccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeAccountButtonNewAccountMouseEntered
        this.homeAccountButtonNewAccount.setBackground(mouseEntered);
    }//GEN-LAST:event_homeAccountButtonNewAccountMouseEntered

    private void homeAccountButtonNewAccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeAccountButtonNewAccountMouseExited
       this.homeAccountButtonNewAccount.setBackground(mouseExited);
    }//GEN-LAST:event_homeAccountButtonNewAccountMouseExited

    private void homeAccountButtonUpdateAccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeAccountButtonUpdateAccountMouseEntered
        this.homeAccountButtonUpdateAccount.setBackground(mouseEntered);
    }//GEN-LAST:event_homeAccountButtonUpdateAccountMouseEntered

    private void homeAccountButtonUpdateAccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeAccountButtonUpdateAccountMouseExited
        this.homeAccountButtonUpdateAccount.setBackground(mouseExited);
    }//GEN-LAST:event_homeAccountButtonUpdateAccountMouseExited

    private void accountDialogNewCreateButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountDialogNewCreateButtonMouseEntered
        this.accountDialogNewCreateButton.setBackground(mouseEntered);
    }//GEN-LAST:event_accountDialogNewCreateButtonMouseEntered

    private void accountDialogNewCreateButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountDialogNewCreateButtonMouseExited
        this.accountDialogNewCreateButton.setBackground(mouseExited);
    }//GEN-LAST:event_accountDialogNewCreateButtonMouseExited

    private void homeTransactionButtonNewTransactionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeTransactionButtonNewTransactionMouseEntered
         this.homeTransactionButtonNewTransaction.setBackground(mouseEntered);
    }//GEN-LAST:event_homeTransactionButtonNewTransactionMouseEntered

    private void homeTransactionButtonNewTransactionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeTransactionButtonNewTransactionMouseExited
         this.homeTransactionButtonNewTransaction.setBackground(mouseExited);
    }//GEN-LAST:event_homeTransactionButtonNewTransactionMouseExited

    private void transactionDialogOptionsButtonSaleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionDialogOptionsButtonSaleMouseEntered
        this.transactionDialogOptionsButtonSale.setBackground(mouseEntered);
    }//GEN-LAST:event_transactionDialogOptionsButtonSaleMouseEntered

    private void transactionDialogOptionsButtonSaleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionDialogOptionsButtonSaleMouseExited
        this.transactionDialogOptionsButtonSale.setBackground(mouseExited);
    }//GEN-LAST:event_transactionDialogOptionsButtonSaleMouseExited

    private void transactionDialogOptionButtonBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionDialogOptionButtonBackMouseEntered
        this.transactionDialogOptionButtonBack.setBackground(mouseEntered);
    }//GEN-LAST:event_transactionDialogOptionButtonBackMouseEntered

    private void transactionDialogOptionButtonBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionDialogOptionButtonBackMouseExited
        this.transactionDialogOptionButtonBack.setBackground(mouseExited);
    }//GEN-LAST:event_transactionDialogOptionButtonBackMouseExited

    private void transactionDialogNewPayButtonCreateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionDialogNewPayButtonCreateMouseEntered
       this.transactionDialogNewPayButtonCreate.setBackground(mouseEntered);
    }//GEN-LAST:event_transactionDialogNewPayButtonCreateMouseEntered

    private void transactionDialogNewPayButtonCreateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionDialogNewPayButtonCreateMouseExited
        this.transactionDialogNewPayButtonCreate.setBackground(mouseExited);
    }//GEN-LAST:event_transactionDialogNewPayButtonCreateMouseExited

    private void transactionDialogNewSaleButtonCreateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionDialogNewSaleButtonCreateMouseEntered
        this.transactionDialogNewSaleButtonCreate.setBackground(mouseEntered);
    }//GEN-LAST:event_transactionDialogNewSaleButtonCreateMouseEntered

    private void transactionDialogNewSaleButtonCreateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionDialogNewSaleButtonCreateMouseExited
       this.transactionDialogNewSaleButtonCreate.setBackground(mouseExited);
    }//GEN-LAST:event_transactionDialogNewSaleButtonCreateMouseExited

    private void transactionDialogSaleDetailsButtonBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionDialogSaleDetailsButtonBackMouseEntered
        this.transactionDialogSaleDetailsButtonBack.setBackground(mouseEntered);
    }//GEN-LAST:event_transactionDialogSaleDetailsButtonBackMouseEntered

    private void transactionDialogSaleDetailsButtonBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionDialogSaleDetailsButtonBackMouseExited
       this.transactionDialogSaleDetailsButtonBack.setBackground(mouseExited);
    }//GEN-LAST:event_transactionDialogSaleDetailsButtonBackMouseExited

    private void transactionDialogPaymentDetailsButtonBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionDialogPaymentDetailsButtonBackMouseEntered
        this.transactionDialogPaymentDetailsButtonBack.setBackground(mouseEntered);
    }//GEN-LAST:event_transactionDialogPaymentDetailsButtonBackMouseEntered

    private void transactionDialogPaymentDetailsButtonBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionDialogPaymentDetailsButtonBackMouseExited
        this.transactionDialogPaymentDetailsButtonBack.setBackground(mouseExited);
    }//GEN-LAST:event_transactionDialogPaymentDetailsButtonBackMouseExited

    private void homeAccountTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeAccountTableMouseClicked

        int selectedRow = this.homeAccountTable.getSelectedRow();
        
        int accountId = (int) this.homeAccountTable.getValueAt(selectedRow,0);
        
        System.out.println("ID => " + accountId);
        
        loadAccountDetails("" + accountId);
        
        this.accountDialogDetails.setLocationRelativeTo(this);
        this.accountDialogDetails.setVisible(true);
    }//GEN-LAST:event_homeAccountTableMouseClicked

    private void goBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBackMouseEntered
        this.goBack.setBackground(mouseEntered);
    }//GEN-LAST:event_goBackMouseEntered

    private void goBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goBackMouseExited
        this.goBack.setBackground(mouseExited);
    }//GEN-LAST:event_goBackMouseExited

    private void goBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackActionPerformed
        this.accountDialogDetails.setVisible(false);
    }//GEN-LAST:event_goBackActionPerformed

    private void transactionDialogNewPayComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionDialogNewPayComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transactionDialogNewPayComboBoxActionPerformed

    private void addressTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTextFieldActionPerformed

    private void jComboBoxAddressOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAddressOrganizationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxAddressOrganizationActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }
   
     private void createAccount(){
        this.ICAccount = Factory.getInstance().getAccountController();
        this.ICU = Factory.getInstance().getUserController();       
        this.IEC = Factory.getInstance().getEmailController();
        String organizationName = null;
        String userName = null;
        
        this.jLabel1.setVisible(false);
        
        //char[] passwordChars = this.jTextField21.getText();
        //String password = new String(passwordChars);       
        //String hashedPwd = this.generarPwdEncriptada(password);
        
        String limitAmount = accountDialogNewLimitLabel.getText();
        String Email = accountDialogNewCorreoLabel.getText();
        String Password = accountDialogNewPasswordLabel.getText();
        
        int userId = this.ICU.getUserIdByEmail(Email);
        int organizationsId = this.organizationId;
        
        
        this.organization = this.ICO.getOrganizationById(organizationId+"");
        organizationName = this.organization.getName();
        
        this.user = this.ICU.getUserByIdOrEmail(null, Email);
        userName = this.user.getName();
        
        boolean flag = false;
        
        try{
            int i = Integer.parseInt(limitAmount);
        } catch(NumberFormatException e){
            this.jLabel1.setVisible(true);
            this.jLabel1.setText("Valor incorrecto para el campo Limite ");
            flag = true;            
        }            
        if(limitAmount.isEmpty() || Email.isEmpty() || Password.isEmpty()){
            this.jLabel1.setVisible(true);
            this.jLabel1.setText("Completa todos los campos");
            flag = true;
        }
        if(userId == 0){
            this.jLabel1.setVisible(true);
            this.jLabel1.setText("El correo ingresado no existe");
            flag = true;
        }       
        if(flag == false){     
        this.ICAccount.createAccount(organizationsId, userId, limitAmount, Password);
        this.IEC.sendNewAccountNotificationMessage(Email, limitAmount, organizationName, userName);
        this.loadAccountsOnTable(organizationsId);
        this.accountDialogNew.setVisible(false);     
        }        
    }
    
    public void resetDialog(){
        this.organizationDialogTextFieldName.setText("Ingresa el nombre de tu organización");
        this.organizationDialogTextFieldDetail.setText("Ingresa una breve descripciön");
        this.organizationDialogTextFieldPassword.setText("*******************");
        this.organizationDialogPublicCheckBox.setSelected(false);
        //this.transactionDialogNewPayLabelStatus.setText("pending");
        //this.transactionDialogNewPayLabelAccountId.setText("000");
        this.transactionDialogNewPayLabelTotalAmount.setText("000");
        //this.transactionDialogNewPayLabelUserId.setText("1234");
        this.transactionDialogNewSaleLabelDetail.setText("Ejemplo");
        this.transactionDialogNewSaleLabelInitialPayment.setText("1234");
        this.transactionDialogNewSaleTotalAmount.setText("1234");
    }
    
    private void loadAccountDetails(String accountId) {
        this.accountDetailsDebtTransactions.setVisible(true);
        DefaultTableModel tableModel = (DefaultTableModel) this.accountDetailsDebtTransactions.getModel();
        tableModel.setRowCount(0);
        
        Account account = this.ICAccount.getAccountById(accountId);
        User user = this.ICU.getUserByIdOrEmail("" + account.getUserId(), null);

        ArrayList<Debt> debtTransactions = this.ICAccount.getAccountDebtTransactions(accountId);

        int debtTransactionsLength = 0;
        for (Debt debt : debtTransactions) {
            debtTransactionsLength++;
        }

        if (debtTransactionsLength != 0) {
            for (Debt debt : debtTransactions) {
                Object[] row = {
                    //debt.getAttributes().getId(),
                    debt.getAttributes().getCreated_at(),
                    debt.getDetail(),
                    debt.getTotalAmount()
                };
                tableModel.addRow(row);
            }
        } else {
            this.transactionsLabel.setText("Aún no hay transacciones");
            this.accountDetailsDebtTransactions.setVisible(false);
        }

        this.accountName.setText(user.getName());
        this.accountEmail.setText(user.getEmail());
        this.accountAddress.setText(user.getAddress());
        this.totalAmount.setText("" + account.getTotal());
        this.limitAmount.setText("" + account.getLimit());
    }
    
    private void searchRowInTable(String searchedText) {
        // Here set the table you want to search on:
        DefaultTableModel tableModel = (DefaultTableModel) this.homeAccountTable.getModel();
        ArrayList<AccountUser> clientsCopy = this.clients;
        
        tableModel.setRowCount(0);
        
        for (AccountUser client : clientsCopy){
            if(client.getUser().getName().toLowerCase().contains(searchedText)) {
                Object[] row = {
                    client.getAccount().getAttributes().getId(),
                    client.getUser().getName(),
                    client.getAccount().getTotal(),
                    client.getAccount().getLimit()
                };
                tableModel.addRow(row);
            }
        }
    }
    
    private void resetTable() {
        DefaultTableModel model = (DefaultTableModel) this.organizationsTable.getModel();
        model.setRowCount(0);
    }
    
    private void resetAccountTable(){
        DefaultTableModel model = (DefaultTableModel) this.homeAccountTable.getModel();
        model.setRowCount(0);
    }
    
    private void reloadAccountTable(int orgIdInt){
        String orgId = String.valueOf(orgIdInt);
        
        this.clients = this.ICO.getAccountAndUserDetails(orgId);
        
        DefaultTableModel model = (DefaultTableModel) this.homeAccountTable.getModel();
       
       for (AccountUser client : this.clients){
           Object[] row = {
               client.getAccount().getAttributes().getId(),
               client.getUser().getName(),
               client.getAccount().getTotal(),
               client.getAccount().getLimit()
           };
           model.addRow(row);
       }
    }
    
    private void resetTransactionTable(){
        DefaultTableModel model = (DefaultTableModel) this.homeTransactionSaleTable.getModel();
        model.setRowCount(0);
        DefaultTableModel model2 = (DefaultTableModel) this.homeTransactionPaymentTable.getModel();
        model2.setRowCount(0);
        
    }
    
    private void reloadTransactionTable(int orgIdInt){
        String orgId = String.valueOf(orgIdInt);
        
        this.resetTransactionTable();
        
        ArrayList<Payment> paymentTransactions = this.ICAccount.getAllPaymentTransactionsByOrgId(orgId);
        DefaultTableModel paymentTableModel = (DefaultTableModel) this.homeTransactionPaymentTable.getModel();
        
        for (Payment payments : paymentTransactions){
            Object[] row = {payments.getAttributes().getId(),payments.getTotalAmount(),payments.getTransactionstatus()};
            paymentTableModel.addRow(row);
        }
        
        ArrayList<Debt> debtTransactions = this.ICAccount.getAllDebtTransactionsByOrgId(orgId);
        DefaultTableModel debtTableModel = (DefaultTableModel) this.homeTransactionSaleTable.getModel();
       
       for (Debt debts : debtTransactions){
           Object[] row = {debts.getAttributes().getId(),debts.getTotalAmount(), debts.getinitialPayment(),debts.getDetail()};
           debtTableModel.addRow(row);
       }
    }
    
     private void loadOrganizationsOnTable(){
        int idFind = this.getOwnerId();
        ArrayList<Organization> organizationList = this.ICO.getAllOrganizationsById(idFind);
        DefaultTableModel model = (DefaultTableModel) this.organizationsTable.getModel();
       
       for (Organization organization : organizationList){
           Object[] row = {organization.getId(),organization.getName(), organization.getDescription()};
           model.addRow(row);
       }
    }
    
    private void loadAccountsOnTable(int orgIdInt){
        
        String orgId = String.valueOf(orgIdInt);
        
        this.clients = this.ICO.getAccountAndUserDetails(orgId);
        
        DefaultTableModel model = (DefaultTableModel) this.homeAccountTable.getModel();
       
       for (AccountUser client : this.clients){
           Object[] row = {
               client.getAccount().getAttributes().getId(),
               client.getUser().getName(),
               client.getAccount().getTotal(),
               client.getAccount().getLimit()
           };
           model.addRow(row);
       }
    }
    
    private void loadDebtTransactionsOnTable(int orgIdInt){
        String orgId = String.valueOf(orgIdInt);
        ArrayList<Debt> debtTransactions = this.ICAccount.getAllDebtTransactionsByOrgId(orgId);
        DefaultTableModel model2 = (DefaultTableModel) this.homeTransactionSaleTable.getModel();
       
       for (Debt debts : debtTransactions){
           Object[] row = {debts.getAttributes().getId(),debts.getTotalAmount(), debts.getinitialPayment(),debts.getDetail()};
           model2.addRow(row);
       }
    }
    
    private void loadPaymentTransactionsOnTable(int orgIdInt){
        String orgId = String.valueOf(orgIdInt);
        
        ArrayList<Payment> paymentTransactions = this.ICAccount.getAllPaymentTransactionsByOrgId(orgId);
        DefaultTableModel model3 = (DefaultTableModel) this.homeTransactionPaymentTable.getModel();
        
        for (Payment payments : paymentTransactions){
            Object[] row = {payments.getAttributes().getId(),payments.getTotalAmount(),payments.getTransactionstatus()};
            model3.addRow(row);
        }
    }
    
    private void loadDebtTransactionDetails(int transactionId){
        
       Debt debt = this.ICT.getDebtById(transactionId);
       
       this.transactionDialogSaleDetailsLabelSaleId.setText(String.valueOf(debt.getAttributes().getId()));
       //this.saleLabelAccountId //Aca hay que hacer otra consulta
       //this.saleLabelStatus.setText(debt.getStatus);//falta estado de la venta
  
       this.transactionDialogSaleDetailsLabelCreated.setText(String.valueOf(debt.getAttributes().getCreated_at()));
       this.transactionDialogSaleDetailsLabelUpdated.setText(String.valueOf(debt.getAttributes().getUpdated_at()));
       this.transactionDialogSaleDetailsLabelDetail.setText(debt.getDetail());
       this.transactionDialogSaleDetailsLabelInitialPay.setText(String.valueOf(debt.getinitialPayment()));
       this.transactionDialogSaleDetailsLabelTotalAmount.setText(String.valueOf(debt.getTotalAmount()));
    }
    
    private void loadPaymentTransactionDetails(int transactionId){
        
        Payment payment = this.ICT.getPaymentById(transactionId);
        
        this.transactionDialogPaymentDetailsLabelPaymentId.setText(String.valueOf(payment.getAttributes().getId()));
        //this.paymentLabelConfirmed
        this.transactionDialogPaymentDetailsLabelStatus.setText(payment.getTransactionstatus());
        this.transactionDialogPaymentDetailsLabelCreated.setText(String.valueOf(payment.getAttributes().getCreated_at()));
        this.transactionDialogPaymentDetailsLabelUpdated.setText(String.valueOf(payment.getAttributes().getUpdated_at()));
        //this.paymentLabelAccountId.setText(String.valueOf(payment.ge));falta esto en el objeto
        this.transactionDialogPaymentDetailsLabelTotalAmount.setText(String.valueOf(payment.getTotalAmount()));
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountAddress;
    private javax.swing.JTable accountDetailsDebtTransactions;
    private javax.swing.JPanel accountDetailsPanel;
    private javax.swing.JDialog accountDialogDetails;
    private javax.swing.JDialog accountDialogNew;
    private javax.swing.JTextField accountDialogNewCorreoLabel;
    private javax.swing.JButton accountDialogNewCreateButton;
    private javax.swing.JTextField accountDialogNewLimitLabel;
    private javax.swing.JTextField accountDialogNewPasswordLabel;
    private javax.swing.JLabel accountDialogNewTitle;
    private javax.swing.JLabel accountDialogNewTitleCorreo;
    private javax.swing.JLabel accountDialogNewTitleLimit;
    private javax.swing.JLabel accountDialogNewTitlePassword;
    private javax.swing.JLabel accountEmail;
    private javax.swing.JLabel accountName;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JPanel createAccountPanel;
    private javax.swing.JButton goBack;
    private javax.swing.JButton homeAccountButtonNewAccount;
    private javax.swing.JButton homeAccountButtonUpdateAccount;
    private javax.swing.JLabel homeAccountLabelAccountAmount;
    private javax.swing.JLabel homeAccountLabelAccountAmountTitle;
    private javax.swing.JLabel homeAccountLabelSearchTitle;
    private javax.swing.JLabel homeAccountLabelTitle;
    private javax.swing.JTable homeAccountTable;
    private javax.swing.JTextField homeAccountTextFieldSearch;
    private javax.swing.JButton homeButtonAccounts;
    private javax.swing.JButton homeButtonBack;
    private javax.swing.JButton homeButtonDetails;
    private javax.swing.JButton homeButtonTransactions;
    private javax.swing.JLabel homeDetailsLabelDetail;
    private javax.swing.JLabel homeDetailsLabelDetailTitle;
    private javax.swing.JLabel homeLabelYourOrgName;
    private javax.swing.JButton homeTransactionButtonNewTransaction;
    private javax.swing.JLabel homeTransactionLabelPaymentTitle;
    private javax.swing.JLabel homeTransactionLabelSaleTitle;
    private javax.swing.JLabel homeTransactionLabelTitle;
    private javax.swing.JTable homeTransactionPaymentTable;
    private javax.swing.JTable homeTransactionSaleTable;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBoxAddressOrganization;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelWithButtons;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel limitAmount;
    private javax.swing.JPanel mainCard1;
    private javax.swing.JPanel mainCard2;
    private javax.swing.JPanel mainCards;
    private javax.swing.JButton organizationButtonLogOff;
    private javax.swing.JButton organizationButtonNewOrganization;
    private javax.swing.JButton organizationDialogButtonAdd;
    private javax.swing.JLabel organizationDialogDetailTitle;
    private javax.swing.JLabel organizationDialogLabelPublicNote;
    private javax.swing.JLabel organizationDialogLabelPublicTitle;
    private javax.swing.JLabel organizationDialogNameTitle;
    private javax.swing.JLabel organizationDialogNameTitle1;
    private javax.swing.JDialog organizationDialogNewOrganization;
    private javax.swing.JPanel organizationDialogPanel;
    private javax.swing.JLabel organizationDialogPasswordTitle;
    private javax.swing.JCheckBox organizationDialogPublicCheckBox;
    private javax.swing.JTextField organizationDialogTextFieldDetail;
    private javax.swing.JTextField organizationDialogTextFieldName;
    private javax.swing.JTextField organizationDialogTextFieldPassword;
    private javax.swing.JLabel organizationDialogTitle;
    private javax.swing.JLabel organizationLabelNote;
    private javax.swing.JLabel organizationLabelTitle;
    private javax.swing.JLabel organizationLabelTitle1;
    private javax.swing.JLabel organizationLabelTitle2;
    private javax.swing.JScrollPane organizationScrollPaneTable;
    private javax.swing.JTable organizationsTable;
    private javax.swing.JPanel panelCard1;
    private javax.swing.JPanel panelCard2;
    private javax.swing.JPanel panelCard3;
    private javax.swing.JPanel panelCards;
    private javax.swing.JLabel priceSymbol;
    private javax.swing.JLabel totalAmount;
    private javax.swing.JDialog transactionDialogNewPay;
    private javax.swing.JButton transactionDialogNewPayButtonCreate;
    private javax.swing.JComboBox<String> transactionDialogNewPayComboBox;
    private javax.swing.JLabel transactionDialogNewPayLabelAccountTitle;
    private javax.swing.JLabel transactionDialogNewPayLabelAccountTitle1;
    private javax.swing.JLabel transactionDialogNewPayLabelNote;
    private javax.swing.JLabel transactionDialogNewPayLabelTitle;
    private javax.swing.JTextField transactionDialogNewPayLabelTotalAmount;
    private javax.swing.JLabel transactionDialogNewPayLabelTotalAmountTitle;
    private javax.swing.JPanel transactionDialogNewPayPanel;
    private javax.swing.JDialog transactionDialogNewSale;
    private javax.swing.JButton transactionDialogNewSaleButtonCreate;
    private javax.swing.JLabel transactionDialogNewSaleLabelAccountIdTitle;
    private javax.swing.JTextField transactionDialogNewSaleLabelDetail;
    private javax.swing.JLabel transactionDialogNewSaleLabelDetailTitle;
    private javax.swing.JTextField transactionDialogNewSaleLabelInitialPayment;
    private javax.swing.JLabel transactionDialogNewSaleLabelInitialPaymentTitle;
    private javax.swing.JLabel transactionDialogNewSaleLabelNote1;
    private javax.swing.JLabel transactionDialogNewSaleLabelNote2;
    private javax.swing.JLabel transactionDialogNewSaleLabelTitle;
    private javax.swing.JPanel transactionDialogNewSalePanel;
    private javax.swing.JTextField transactionDialogNewSaleTotalAmount;
    private javax.swing.JLabel transactionDialogNewSaleTotalAmountTitle;
    private javax.swing.JButton transactionDialogOptionButtonBack;
    private javax.swing.JDialog transactionDialogOptions;
    private javax.swing.JButton transactionDialogOptionsButtonPayment;
    private javax.swing.JButton transactionDialogOptionsButtonSale;
    private javax.swing.JPanel transactionDialogOptionsPanel;
    private javax.swing.JLabel transactionDialogOptionsTitle;
    private javax.swing.JDialog transactionDialogPaymentDetails;
    private javax.swing.JButton transactionDialogPaymentDetailsButtonBack;
    private javax.swing.JLabel transactionDialogPaymentDetailsLabelAccountId;
    private javax.swing.JLabel transactionDialogPaymentDetailsLabelAccountIdTitle;
    private javax.swing.JLabel transactionDialogPaymentDetailsLabelCreated;
    private javax.swing.JLabel transactionDialogPaymentDetailsLabelCreatedTitle;
    private javax.swing.JLabel transactionDialogPaymentDetailsLabelNote1;
    private javax.swing.JLabel transactionDialogPaymentDetailsLabelPaymentId;
    private javax.swing.JLabel transactionDialogPaymentDetailsLabelPaymentIdTitle;
    private javax.swing.JLabel transactionDialogPaymentDetailsLabelStatus;
    private javax.swing.JLabel transactionDialogPaymentDetailsLabelStatusTitle;
    private javax.swing.JLabel transactionDialogPaymentDetailsLabelTitle;
    private javax.swing.JLabel transactionDialogPaymentDetailsLabelTotalAmount;
    private javax.swing.JLabel transactionDialogPaymentDetailsLabelTotalAmountTitle;
    private javax.swing.JLabel transactionDialogPaymentDetailsLabelUpdated;
    private javax.swing.JLabel transactionDialogPaymentDetailsLabelUpdatedTitle;
    private javax.swing.JLabel transactionDialogPaymentDetailsLabelUserId;
    private javax.swing.JLabel transactionDialogPaymentDetailsLabelUserIdTitle;
    private javax.swing.JPanel transactionDialogPaymentDetailsPanel;
    private javax.swing.JPanel transactionDialogPaymentDetailsPanel1;
    private javax.swing.JPanel transactionDialogPaymentDetailsPanel2;
    private javax.swing.JPanel transactionDialogPaymentDetailsPanel3;
    private javax.swing.JPanel transactionDialogPaymentDetailsPanel4;
    private javax.swing.JPanel transactionDialogPaymentDetailsPanel5;
    private javax.swing.JDialog transactionDialogSaleDetails;
    private javax.swing.JButton transactionDialogSaleDetailsButtonBack;
    private javax.swing.JLabel transactionDialogSaleDetailsLabelAccountId;
    private javax.swing.JLabel transactionDialogSaleDetailsLabelAccountIdTitle;
    private javax.swing.JLabel transactionDialogSaleDetailsLabelCreated;
    private javax.swing.JLabel transactionDialogSaleDetailsLabelCreatedTitle;
    private javax.swing.JLabel transactionDialogSaleDetailsLabelDetail;
    private javax.swing.JLabel transactionDialogSaleDetailsLabelDetailTitle;
    private javax.swing.JLabel transactionDialogSaleDetailsLabelInitialPay;
    private javax.swing.JLabel transactionDialogSaleDetailsLabelInitialPayTitle;
    private javax.swing.JLabel transactionDialogSaleDetailsLabelNote1;
    private javax.swing.JLabel transactionDialogSaleDetailsLabelNote2;
    private javax.swing.JLabel transactionDialogSaleDetailsLabelSaleId;
    private javax.swing.JLabel transactionDialogSaleDetailsLabelSaleIdTitle;
    private javax.swing.JLabel transactionDialogSaleDetailsLabelStatus;
    private javax.swing.JLabel transactionDialogSaleDetailsLabelStatusTitle;
    private javax.swing.JLabel transactionDialogSaleDetailsLabelTitle;
    private javax.swing.JLabel transactionDialogSaleDetailsLabelTotalAmount;
    private javax.swing.JLabel transactionDialogSaleDetailsLabelTotalAmountTitle;
    private javax.swing.JLabel transactionDialogSaleDetailsLabelUpdated;
    private javax.swing.JLabel transactionDialogSaleDetailsLabelUpdatedTitle;
    private javax.swing.JPanel transactionDialogSaleDetailsPanel;
    private javax.swing.JPanel transactionDialogSaleDetailsPanel1;
    private javax.swing.JPanel transactionDialogSaleDetailsPanel2;
    private javax.swing.JPanel transactionDialogSaleDetailsPanel3;
    private javax.swing.JPanel transactionDialogSaleDetailsPanel4;
    private javax.swing.JPanel transactionDialogSaleDetailsPanel5;
    private javax.swing.JPanel transactionDialogSaleDetailsPanel6;
    private javax.swing.JLabel transactionsLabel;
    // End of variables declaration//GEN-END:variables
}
