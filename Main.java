import java.util.Scanner;
class Main {
    static Scanner input = new Scanner(System.in);
    static String name="danujav",password="1234";
    static String[][] suppliers = new String[0][2];
    static String[] item_category=new String[0];
    static String[][] items=new String[0][6];

    private final static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.equals("Linux")) {
                System.out.print("\033\143");
            } else if (os.equals("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            //handle the exception
            System.err.println(e.getMessage());
        }
    }
    public static void main(String args[]) {
        loginPage();
    }
    public static void loginPage() {
        System.out.printf("+--------------------------------------------------------------------------+%n");
        System.out.printf("%-30s"+"%s"+"%23s%n","|","LOGIN PAGE","\t\t   |");
        System.out.printf("+--------------------------------------------------------------------------+%n\n");
        boolean flag=false;
        L1: do{
            System.out.print("User Name : ");
            if(name.equals(input.next())) {
                L2: do{
                    System.out.print("\nPassword  : ");
                    if(password.equals(input.next())){
                        clearConsole();
                        HomePage();
                        break L1;
                    }else{
                        System.out.println("password is incorrect. please try again!");
                    }
                }while(flag!=true);
            }else{
                System.out.print("user name is invalid. please try again!\n\n");
            }
        }while(flag!=true);
    }
    public static void HomePage() {
        System.out.printf("+---------------------------------------------------------------------------+%n");
        System.out.printf("%-17s"+"%s"+"%20s%n","|","WELCOME TO  IJSE STOCK MANAGEMENT SYSTEM","|");
        System.out.printf("+---------------------------------------------------------------------------+%n\n");
        System.out.printf("%s%d%s %s","[",1,"]","Change the Credentials");
        System.out.printf("%10s%d%s %s%n","[",2,"]","Suppiler Manage");
        System.out.printf("%s%d%s %s","[",3,"]","Stock Manage");
        System.out.printf("%20s%d%s %s%n","[",4,"]","Log out");
        System.out.printf("%s%d%s %s","[",5,"]","Exit the system");
        System.out.print("\n\nEnter an option to continue > ");
        int opt=input.nextInt();//1 2 3 4 5
        switch (opt) {
            case 1:
                clearConsole();
                cred();
                break;
            case 2:
                clearConsole();
                supManage();
                break;
            case 3:
                clearConsole();
                stoManage();
                break;
            case 4:
                clearConsole();
                logout();
                break;
            case 5:
                clearConsole();
                exit();
                break;
            default:
                System.out.println("Invalid option! Please try again.");
        }
    }
    public static void cred() {
        System.out.printf("+-------------------------------------------------------------------------+%n");
        System.out.printf("%-30s"+"%s"+"%23s%n","|","CREDENTIAL MANAGE","\t  |");
        System.out.printf("+-------------------------------------------------------------------------+%n");
        boolean flag=false;
        L1: do{
            System.out.print("\nPlease enter the user name to verify it's you : ");
            String Name = input.next();
            if(name.equals(Name)) {
                System.out.print("Hey "+Name+"\n");
                L2:	do{
                    System.out.print("Enter your current password: ");
                    if(password.equals(input.next())){
                        System.out.print("Enter your new password: ");
                        password = input.next();
                        System.out.print("\nPassword changed successfully! Do you want to go home page (Y/N): ");
                        char ck=input.next().charAt(0);
                        if(ck == 'Y' || ck=='y') {
                            clearConsole();
                            HomePage();
                        }else{
                            clearConsole();
                            loginPage();
                        }
                        break L1;
                    }else{
                        System.out.println("incorrect password. try again!\n");
                    }
                }while(flag!=true);
            }else{
                System.out.print("invalid user name. try again!"+"\n");
            }
        }while(flag!=true);
    }
    public static void supManage() {
        System.out.printf("+--------------------------------------------------------------------------+%n");
        System.out.printf("%-30s"+"%s"+"%23s%n","|","SUPPLIER MANAGE","\t\t   |");
        System.out.printf("+--------------------------------------------------------------------------+%n\n");
        System.out.printf("%s%d%s %s","[",1,"]","Add Supplier");
        System.out.printf("%10s%d%s %s%n","[",2,"]","Update Supplier");
        System.out.printf("%s%d%s %s","[",3,"]","Delete Supplier");
        System.out.printf("%7s%d%s %s%n","[",4,"]","View Supplier");
        System.out.printf("%s%d%s %s","[",5,"]","Search Supplier");
        System.out.printf("%7s%d%s %s%n","[",6,"]","Home page");
        System.out.print("\nEnter an option to continue > ");//1 2 3 4 5
        int sup=input.nextInt();
        switch (sup) {
            case 1:
                clearConsole();
                addSup();
                break;
            case 2:
                clearConsole();
                updateSup();
                break;
            case 3:
                clearConsole();
                deleteSup();
                break;
            case 4:
                clearConsole();
                viewSup();
                break;
            case 5:
                clearConsole();
                searchSup();
                break;
            case 6:
                clearConsole();
                home();
                break;
            default:
                System.out.println("Invalid option! Please try again.");
        }
    }
    public static void addSup() {
        System.out.printf("+--------------------------------------------------------------------------+%n");
        System.out.printf("%-30s"+"%s"+"%23s%n","|","ADD SUPPLIER","\t\t   |");
        System.out.printf("+--------------------------------------------------------------------------+%n");
        while (true) {
            System.out.print("\nSupplier ID   : ");
            String Id = input.next();
            boolean flag = false;
            for (int i = 0; i < suppliers.length; i++) {
                if (Id.equals(suppliers[i][0])) {
                    System.out.println("already exists. try another supplier id!");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                grow();
                suppliers[suppliers.length - 1][0] = Id;
                System.out.print("Supplier Name : ");
                suppliers[suppliers.length - 1][1] = input.next();
                System.out.print("added Successfully! Do you want to add another Supplier(Y/N)? ");
                char aS=input.next().charAt(0);
                if(aS== 'Y' || aS=='y') {
                    clearConsole();
                    addSup();
                    break;
                }else{
                    clearConsole();
                    supManage();
                }
            }
        }
    }
    public static void grow() {
        String[][] temp = new String[suppliers.length + 1][2];
        for (int i = 0; i < suppliers.length; i++) {
            for (int j = 0; j < suppliers[i].length; j++) {
                temp[i][j] = suppliers[i][j];
            }
        }
        suppliers = temp;
    }
    public static void updateSup() {
        System.out.printf("+--------------------------------------------------------------------------+%n");
        System.out.printf("%-30s"+"%s"+"%23s%n","|","UPDATE SUPPLIER","\t\t   |");
        System.out.printf("+--------------------------------------------------------------------------+%n");
        boolean flag=false;
        L1: while(flag!=true){
            System.out.print("\nSupplier ID   : ");
            String Id=input.next();
            for(int i=0;i<suppliers.length;i++){
                if(Id.equals(suppliers[i][0])){
                    System.out.println("Supplier name : "+suppliers[i][1]+"\n");
                    System.out.print("Enter the new supplier name : ");
                    String name=input.next();
                    suppliers[i][1]=name;
                    flag=true;
                    break;
                }
            }
            if(flag==false){
                System.out.println("can't find supplier id. try again!");
                continue L1;
            }
            System.out.print("Updated Successfully! Do you want to update another supplier(Y/N)? ");
            char uS=input.next().charAt(0);
            if(uS== 'Y' || uS=='y') {
                clearConsole();
                updateSup();
            }else{
                clearConsole();
                supManage();
            }
        }
    }
    public static void deleteSup() {
        System.out.printf("+--------------------------------------------------------------------------+%n");
        System.out.printf("%-30s"+"%s"+"%23s%n","|","DELETE SUPPLIER","\t\t   |");
        System.out.printf("+--------------------------------------------------------------------------+%n");
        int index=0;
        L1: while(true){
            System.out.print("\nSupplier ID   : ");
            String Id = input.next();
            boolean duplicate = isDuplicate(Id);
            if(duplicate==false){
                System.out.print("can't find supplier id.try again!\n");
            }else{
                for (int i = 0; i < suppliers.length; i++){
                    if(suppliers[i][0].equals(Id)){
                        String[][]temp= new String[suppliers.length-1][2];
                        for (int j = 0; j < suppliers.length; j++){
                            if(j!=i){
                                temp[index++]=suppliers[j];
                            }
                        }
                        suppliers=temp;
                        System.out.print("deleted successfully!");
                        break;
                    }
                }
                System.out.print(" Do you want to delete another(Y/N)? ");
                char dS=input.next().charAt(0);
                if(dS== 'Y' || dS=='y') {
                    clearConsole();
                    deleteSup();
                }else{
                    clearConsole();
                    supManage();
                }
            }
        }
    }
    public static boolean isDuplicate(String id) {
        for (int i = 0; i < suppliers.length; i++) {
            if (suppliers[i][0].equals(id)) {
                return true;
            }
        }
        return false;
    }
    public static void viewSup() {
        System.out.printf("+--------------------------------------------------------------------------+%n");
        System.out.printf("%-30s"+"%s"+"%23s%n","|","VIEW SUPPLIER","\t\t   |");
        System.out.printf("+--------------------------------------------------------------------------+%n\n");
        System.out.println("+----------------------+-----------------------+");
        System.out.println("|     SUPPLIER ID      |      SUPPLIER NAME    |" );
        System.out.println("+----------------------+-----------------------+");

        for (int i = 0; i < suppliers.length; i++){
            System.out.printf("|%12s  %8s|%4s   %-16s|%n",suppliers[i][0]," "," " ,suppliers[i][1]);
        }
        System.out.printf("+----------------------+-----------------------+");
        System.out.print("\nDo you want to go supplier manage page(Y/N)? ");
        char vS=input.next().charAt(0);
        if(vS== 'Y' || vS=='y') {
            clearConsole();
            supManage();
        }else{
            clearConsole();
            HomePage();
        }
    }
    public static void searchSup() {
        System.out.printf("+--------------------------------------------------------------------------+%n");
        System.out.printf("%-30s"+"%s"+"%23s%n","|","SEARCH SUPPLIER","\t\t   |");
        System.out.printf("+--------------------------------------------------------------------------+%n");
        L1:while(true){
            System.out.print("\nSupplier ID   : ");
            String Id = input.next();
            boolean duplicate = isDuplicate(Id);
            if(duplicate==false){
                System.out.print("can't find supplier id.try again!\n");
            }else{
                for (int i = 0; i < suppliers.length; i++){
                    if(suppliers[i][0].equals(Id)){
                        System.out.print("Supplier name : "+suppliers[i][1]);
                    }
                }
                System.out.print("\nadded sucessfully! Do you want to add another find(Y/N)? ");
                char sS=input.next().charAt(0);
                if(sS== 'Y' || sS=='y') {
                    clearConsole();
                    searchSup();
                }else{
                    clearConsole();
                    supManage();
                }
            }
        }
    }
    public static void home(){
        HomePage();
    }
    public static void manageItemCat(){
        System.out.printf("+--------------------------------------------------------------------------+%n");
        System.out.printf("%-30s"+"%s"+"%23s%n","|","MANAGE ITEM CATEGORY","\t   |");
        System.out.printf("+--------------------------------------------------------------------------+%n");
        System.out.println();
        System.out.printf("%s%d%s %s","[",1,"]","Add New Item Category");
        System.out.printf("%10s%d%s %s%n","[",2,"]","Delete Item Category");
        System.out.printf("%s%d%s %s","[",3,"]","Update Item Category");
        System.out.printf("%11s%d%s %s%n","[",4,"]","Stock Management");
        System.out.print("\nEnter an option to continue > ");
        int mic=input.nextInt();
        switch (mic) {
            case 1:
                clearConsole();
                addSto();
                break;
            case 2:
                clearConsole();
                deleteSto();
                break;
            case 3:
                clearConsole();
                updateSto();
                break;
            case 4:
                clearConsole();
                stoManage();
                break;
            default:
                System.out.println("Invalid option! Please try again.");
        }
    }
    public static void addSto(){
        System.out.printf("+--------------------------------------------------------------------------+%n");
        System.out.printf("%-30s"+"%s"+"%23s%n","|","ADD ITEM CATEGORY","\t   |");
        System.out.printf("+--------------------------------------------------------------------------+%n");
        while (true) {
            System.out.print("\nEnter the new item category: ");
            String Id = input.next();
            boolean flag = false;
            for (int i = 0; i < item_category.length; i++) {
                if (Id.equals(item_category[i])) {
                    System.out.println("already exists. try another item category! ");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                growSto();
                item_category[item_category.length - 1] = Id;
                System.out.print("added Successfully! Do you want to add another category(Y/N)? ");
                char aS=input.next().charAt(0);
                if(aS== 'Y' || aS=='y') {
                    clearConsole();
                    addSto();
                    break;
                }else{
                    clearConsole();
                    stoManage();
                }
            }
        }
    }
    public static void growSto() {
        String[] temp = new String[item_category.length + 1];
        for (int i = 0; i < item_category.length; i++) {
            temp[i] = item_category[i];
        }
        item_category = temp;
    }
    public static void  deleteSto(){
        System.out.printf("+--------------------------------------------------------------------------+%n");
        System.out.printf("%-30s"+"%s"+"%23s%n","|","DELETE ITEM CATEGORY","\t   |");
        System.out.printf("+--------------------------------------------------------------------------+%n");
        boolean flag=false;
        L1: while(flag!=true){
            System.out.print("\nEnter the item category : ");
            String Id = input.next();
            for(int i=0;i<item_category.length;i++){
                if(Id.equals(item_category[i])){
                    item_category=growdel(i);
                    System.out.print("deleted successfully!");
                    flag=true;
                    break;
                }
            }
            if(flag==false){
                System.out.print("can't find this item category.try again!\n");
                continue L1;
            }
            System.out.print(" Do you want to delete another(Y/N)? ");
            char dS=input.next().charAt(0);
            if(dS== 'Y' || dS=='y') {
                clearConsole();
                deleteSto();
            }else{
                clearConsole();
                stoManage();
            }
        }
    }
    public static String[] growdel(int x){
        String []temp=new String[item_category.length-1];
        for(int i=0,j=0;i<item_category.length;i++){
            if(x!=i){
                temp[j++]=item_category[i];
            }
        }
        return temp;
    }
    public static void updateSto(){
        System.out.printf("+--------------------------------------------------------------------------+%n");
        System.out.printf("%-30s"+"%s"+"%23s%n","|","UPDATE ITEM CATEGORY","\t   |");
        System.out.printf("+--------------------------------------------------------------------------+%n");
        boolean flag=false;
        L1: while(flag!=true){
            System.out.print("\nEnter the item category : ");
            String Id = input.next();
            for(int i=0;i<item_category.length;i++){
                if(Id.equals(item_category[i])){
                    System.out.print ("Enter the new item category : ");
                    String name=input.next();
                    item_category[i]=name;
                    flag=true;
                    break;
                }
            }
            if(flag==false){
                System.out.print ("can't find supplier id.try again!\n");
                continue L1;
            }
            System.out.print("Update Successfully ! Do you want to update another supplier(Y/N)? ");
            char uS=input.next().charAt(0);
            if(uS== 'Y' || uS=='y') {
                clearConsole();
                updateSto();
            }else{
                clearConsole();
                manageItemCat();
            }
        }
    }
    public static void addItem(){
        System.out.printf("+--------------------------------------------------------------------------+%n");
        System.out.printf("%-30s"+"%s"+"%23s%n","|","ADD ITEM","\t\t\t   |");
        System.out.printf("+--------------------------------------------------------------------------+%n");
        if(item_category.length==0){
            System.out.print("\nOOPS! It seems that you don't have any item categories in the system. ");
            System.out.print("\nDo you want to add a new item category(Y/N)? ");
            char aS=input.next().charAt(0);
            if(aS== 'Y' || aS=='y') {
                clearConsole();
                addSto();
            }else{
                clearConsole();
                stoManage();
            }
        }
        if(suppliers.length==0){
            System.out.print("\nOOPS! It seems that you don't have any supplers in the system. ");
            System.out.print("\nDo you want to add a new supplier(Y/N)? ");
            char aS=input.next().charAt(0);
            if(aS== 'Y' || aS=='y') {
                clearConsole();
                addSup();
            }else{
                clearConsole();
                stoManage();
            }
        }
        boolean flag=false;
        items=growitems();

        L1: while(flag!=true){
            System.out.print("\nItem code : ");
            String item=input.next();
            for(int i=0;i<items.length;i++){
                if(item.equals(items[i][1])){
                    System.out.println("already added. try another item code!");
                    continue L1;
                }
            }
            if(flag==false){
                flag=true;
                System.out.println("\nSuppliers list:");
                suppierlist();

                System.out.print("\nEnter the supplier number > ");
                items[items.length-1][0]=suppliers[input.nextInt()-1][0];

                items[items.length-1][1]=item;

                System.out.println("\nItem categories: ");
                categories_list();

                System.out.print("\nEnter the category number > ");
                items[items.length-1][5]=item_category[input.nextInt()-1];

                System.out.print("\nDiscription : ");
                items[items.length-1][2]=input.next();

                System.out.print("Unit price  : ");
                items[items.length-1][3]=input.next();

                System.out.print("Qty on hand : ");
                items[items.length-1][4]=input.next();

                System.out.print("added successfully! Do you want add another Item(Y/N)? ");
                char in=input.next().charAt(0);
                if(in=='Y' || in=='y'){
                    clearConsole();
                    addItem();
                }else{
                    clearConsole();
                    stoManage();
                }
            }
        }
    }
    public static void categories_list(){
        System.out.println("+---------+------------------------------+");
        System.out.println("|    #    |        CATEGORY NAME         |");
        System.out.println("+---------+------------------------------+");
        for(int i=0;i<item_category.length;i++){
            System.out.println("|    "+(i+1)+"    |             "+item_category[i]+"             |");
        }
        System.out.println("+---------+------------------------------+");
    }
    public static void suppierlist(){
        System.out.println("+---------+-----------------------+-----------------------------+");
        System.out.println("|    #    |      SUPPLIER ID      |         SUPPLIER NAME       |");
        System.out.println("+---------+-----------------------+-----------------------------+");
        for(int i=0;i<suppliers.length;i++){
            System.out.println("|    "+(i+1)+"    |          "+suppliers[i][0]+"         |            "+suppliers[i][1]+"           |");
        }
        System.out.println("+---------+-----------------------+-----------------------------+");
    }
    public static String [][] growitems(){
        String [][]temp=new String[items.length+1][6];
        for(int i=0;i<items.length;i++){
            for(int j=0;j<items[i].length;j++){
                temp[i][j]=items[i][j];
            }
        }return temp;
    }

    public static void getItemsSupWise(){
        System.out.printf("+--------------------------------------------------------------------------+%n");
        System.out.printf("|                         SEARCH ITEMS SUPPLIER WISE                       |");
        System.out.printf("\n+--------------------------------------------------------------------------+%n");
        L1:while(true){
            System.out.print("\nEnter Supplier ID: ");
            String Id = input.next();
            boolean flag =true;
            for (int i = 0; i < suppliers.length; i++){
                if(Id.equals(suppliers[i][0])){
                    flag=false;
                    System.out.print("Supplier Name: "+suppliers[i][1]);
                    break;
                }
            }
            if(flag){
                System.out.print("Invalid Supplier Id. Try again!\n");
                continue L1;
            }
            System.out.println("\n\n+-------------+---------------+--------------+---------------+------------+");
            System.out.print("|  ITEM CODE  |  DESCRIPTION  |  UNIT PRICE  |  QTY ON HAND  |  CATEGORY  |\n");
            System.out.println("+-------------+---------------+--------------+---------------+------------+");
            for(int i=0;i<suppliers.length;i++){
                if(Id.equals(suppliers[i][0])){
                    for(int j=0;j<items.length;j++){
                        if(suppliers[i][0].equals(items[j][0])){
                            System.out.println("|     "+items[j][1]+"    |     "+items[j][2]+"     |     "+items[j][3]+"      |       "+items[j][4]+"     |    "+items[j][5]+"    |");
                            System.out.print("+-------------+---------------+--------------+---------------+------------+");
                        }
                    }
                }
            }
            System.out.print("\nsearch successfully! Do you want to another search?(Y/N) ");
            char gS=input.next().charAt(0);
            if(gS== 'Y' || gS=='y') {
                clearConsole();
                getItemsSupWise();
            }else{
                clearConsole();
                stoManage();
            }
        }
    }
    public static void viewItems(){
        do{
            System.out.printf("+--------------------------------------------------------------------------+%n");
            System.out.printf("%-30s"+"%s"+"%23s%n","|","VIEW ITEMS","\t\t   |");
            System.out.printf("+--------------------------------------------------------------------------+%n\n");
            for (int k = 0; k <item_category.length ; k++){
                System.out.println("\n"+item_category[k]+":");
                System.out.println("+-------------+-------------+-------------+-------------+-------------+");
                System.out.printf("%-6s%-8s%-6s%-8s%-5s%-9s%-5s%-9s%-7s%-7s%s","|","SID","|","CODE","|","DESC","|","PRICE","|","QTY","|\n");
                System.out.println("+-------------+-------------+-------------+-------------+-------------+");
                for (int i = 0;i < items.length;i++) {
                    if (item_category[k].equals(items[i][5])) {
                        System.out.print("|");
                        for (int j = 0; j < items[i].length; j++){
                            if (j != 5) System.out.printf("%9s%5s",items[i][j],"|");
                        }
                        System.out.println();
                    }
                }
                System.out.println("+-------------+-------------+-------------+-------------+-------------+\n");
            }
            System.out.print("\nDo you want to go stock manage page?(Y/N) ");
            char yA =input.next().charAt(0);
            if(yA=='Y'|| yA=='y'){
                clearConsole();
                stoManage();
            }else{
                clearConsole();
                viewItems();
            }
        }while(true);
    }
    public static void rankItemsPerUnitPrice(){
        System.out.printf("+--------------------------------------------------------------------------+%n");
        System.out.printf("%-30s"+"%s"+"%23s%n","|","RANKED UNIT PRICE","\t   |");
        System.out.printf("+--------------------------------------------------------------------------+%n");
        for (int i = 0; i < items.length-1; i++){
            for (int j = 0; j < items.length-1; j++){
                if(Integer.parseInt(items[j][3])>Integer.parseInt(items[j+1][3])){
                    String[] temp = items[j];
                    items[j]=items[j+1];
                    items[j+1]=temp;
                }
            }
        }

        System.out.println("+-------------+-------------+-------------+-------------+-------------+-------------+");
        System.out.printf("%-6s%-8s%-6s%-8s%-5s%-9s%-5s%-9s%-7s%-7s%-5s%-9s%s","|","SID","|","CODE","|","DESC","|","PRICE","|","QTY","|","CAT","|\n");
        System.out.println("+-------------+-------------+-------------+-------------+-------------+-------------+");
        for (int i = 0;i < items.length;i++) {
            System.out.print("|");
            for (int j = 0; j < items[i].length; j++){
                System.out.printf("%9s%5s",items[i][j],"|");
            }
            System.out.println();
        }
        System.out.println("+-------------+-------------+-------------+-------------+-------------+-------------+");
        System.out.print("\nDo you want to go stock manage page?(Y/N) ");
        char vS=input.next().charAt(0);
        if(vS== 'Y' || vS=='y') {
            clearConsole();
            stoManage();
        }else{
            clearConsole();
            stoManage();
        }
    }
    public static void stoManage(){
        System.out.printf("+--------------------------------------------------------------------------+%n");
        System.out.printf("%-30s"+"%s"+"%23s%n","|","STOCK MANAGEMENT","\t\t   |");
        System.out.printf("+--------------------------------------------------------------------------+%n");
        System.out.println();
        System.out.printf("%s%d%s %s","[",1,"]","Manage Item Categories");
        System.out.printf("%10s%d%s %s%n","[",2,"]","Add Item");
        System.out.printf("%s%d%s %s","[",3,"]","Get Items Supplier Wise");
        System.out.printf("%9s%d%s %s%n","[",4,"]","View Items");
        System.out.printf("%s%d%s %s","[",5,"]","Rank Items Per Unit Price");
        System.out.printf("%7s%d%s %s%n","[",6,"]","Home Page");
        System.out.print("\nEnter an option to continue > ");
        int sto=input.nextInt();
        switch (sto) {
            case 1:
                clearConsole();
                manageItemCat();
                break;
            case 2:
                clearConsole();
                addItem();
                break;
            case 3:
                clearConsole();
                getItemsSupWise();
                break;
            case 4:
                clearConsole();
                viewItems();
                break;
            case 5:
                clearConsole();
                rankItemsPerUnitPrice();
                break;
            case 6:
                clearConsole();
                home();
                break;
            default:
                System.out.println("Invalid option! Please try again.");
        }
    }
    public static void logout(){
        loginPage();
    }
    public static void exit(){
        System.exit(0);
    }
}