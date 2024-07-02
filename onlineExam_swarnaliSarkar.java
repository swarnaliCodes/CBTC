import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class students{
    String name;
    String pw;

    students(String name,String pw){
        this.name = name;
        this.pw = pw;
    }
}
class questions{
    String question;
    List<String> options;
    int ans;

    questions(String question,List<String> options, int ans){
        this.question = question;
        this.options = options;
        this.ans = ans;
    }

}
class onlineExam_swarnaliSarkar{

    static List<questions> q = new ArrayList<>();
    static List<students> s = new ArrayList<>();
    static students currentStudent;
    static int sessionActive = 0;

    public static void addOptions(){

        List<String> o1 = new ArrayList<>();
        o1.add(" Process management");
        o1.add(" Memory management");
        o1.add("Device management");
        o1.add("Web browsing");
        questions q1 = new questions("Which of the following is NOT a primary function of an operating system?", o1, 4);
        q.add(q1);
        List<String> o2 = new ArrayList<>();
        o2.add("  The process is terminated.");
        o2.add(" The process is using the CPU and executing instructions.");
        o2.add(" The process is idle but ready to run when resources become available.");
        o2.add(" The process is permanently blocked and cannot continue execution.");
        questions q2 = new questions("In a multitasking operating system, what happens when a process is placed in the \"waiting\" state?", o2, 3);
        q.add(q2);
        List<String> o3 = new ArrayList<>();
        o3.add("  FAT (File Allocation Table)");
        o3.add(" NTFS (New Technology File System)");
        o3.add(" EXT (Extended file system)");
        o3.add("  HFS+ (Hierarchical File System Plus)");
        questions q3 = new questions("A file system is a method for organizing files and directories on a storage device. What type of file system organizes data using fixed-size blocks called clusters?", o3, 1);
        q.add(q3);
    }

    public static void register(Scanner sc){
        System.out.println("ENTER A USERNAME:");
        String name = sc.nextLine();
        System.out.println("ENTER A PASSWORD(SHOULD CONTAIN AT LEAST 1 UPPERCASE LETTER, SPECIAL CHARACTER, 1 NUMBER AND CAN BE MAXIMUM OF 8 LETTERS):");
        String pw = sc.nextLine();
        for(students students: s){
            if(students.name.equals(name)){
                System.out.println("USERNAME IS NOT AVAILABLE!!");
                return;
            }
        }
        students student = new students(name,pw);
        s.add(student);
        System.out.println("REGISTRATION SUCCESSFULL!!");
        System.out.println("PLEASE ENTER YOUR DETAILS AGAIN TO LOG IN");
        login(sc);
    }
    public static void login(Scanner sc){
        System.out.println("ENTER USERNAME FOLLOWED BY YOUR PASSWORD");
        String name = sc.nextLine();
        System.out.println("ENTER A PASSWORD");
        String pw = sc.nextLine();

        for(students st:s){
            if(st.name.equals(name)&&st.pw.equals(pw)){
                currentStudent = st;
                sessionActive = 1;
                start(sc);
                return;
            }
        }
        System.out.println("CANNOT FIND USER.TRY AGAIN WITH CORRECT DETAILS!!");
    }
    public static void start(Scanner sc){
        System.out.println("HI, "+ currentStudent.name);
        for (int i = 0; i < q.size(); i++) {
            questions question = q.get(i);
            System.out.println("QUESTION "+(i+1)+":"+question.question);
            for(int j=0;j<question.options.size();j++){
                System.out.println(j+1 + ")" + question.options.get(j));
                System.out.println();
            }
            System.out.println("CHOOSE THE CORRECT OPTION");
            int ch = sc.nextInt();
            if(ch == question.ans){
                System.out.println("CORRECT ANSWER");
                System.out.println();
            }else{
                System.out.println("WRONG ANSWER");
                System.out.println();
            }
        }
        System.out.println("CONGRATULATIONS! YOU'VE SUCCESSFULLY COMPLETED THE TEST!!");
        sessionActive = 0;
    }
    public static void main(String[] args) {
        addOptions();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. REGISTER");
            System.out.println("2. LOG IN");
            System.out.println("3. EXIT");

            System.out.println("ENTER YOUR CHOICE");
            int ch = sc.nextInt();
            sc.nextLine();
            switch(ch){
                case 1:{
                    register(sc);
                    break;
                }
                case 2:{
                    login(sc);
                    break;
                }
                case 3:{
                    System.out.println("EXITING THE SYSTEM");
                    System.exit(0);
                }
                default:
                    System.out.println("PLEASE SELECT A VALID OPTION");
            }
        }
    }
}
