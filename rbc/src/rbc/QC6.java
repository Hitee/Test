package rbc;


import com4j.Com4jObject;


 
public class QC6 {  
 
   private ITDConnection connection;  
   private static String TP_Pfad = "Subject";  
//   private static String TP_Pfad = "Subject\\Frontend";  
 
   //  private String testSetName = "Opera";  
 
   public void doInit(String url, String domain, String project,  
           String username, String password) {  
       System.out.println(">>>>> doInit <<<<< ");  
       connection = ClassFactory.createTDConnection();  
 
       connection.initConnectionEx(url);  
       System.out.println(connection.connected() + ", connected!");  
 
       connection.connectProjectEx(domain, project, username, password);  
       System.out.println(connection.connected() + ", logged in!");  
 
   }  
 
   public void disConnect() {  
       System.out.println(">>>>> disConnect <<<<< ");  
       connection.disconnectProject();  
   }  
 
 
   //------------------------TestPlan  
 
   public void TP_testPlanRead2(String tpPfad){  
       System.out.println(">>>>> TP_testPlanRead2 <<<<< " + tpPfad);  
       Com4jObject coTreeManager = connection.treeManager();  
       ITreeManager treeManager = coTreeManager.queryInterface(ITreeManager.class);  
 
       Com4jObject coSubjectNode = treeManager.treeRoot(tpPfad);  
       ISubjectNode subjectNode = coSubjectNode.queryInterface(ISubjectNode.class);  
 
       for(int i = 0; i < subjectNode.count(); i++){  
           printNode(subjectNode);  
       }  
   }  
 
   private static void printNode(ISubjectNode node) {  
       System.out.println(node.name() + " <<< Top Level Element");  
       for (int i = 1; i < node.count(); i++) {  
           printNode(node.child(i),"    ");  
       }  
   }  
 
   private static void printNode(ISysTreeNode node,String inset) {  
       System.out.println(inset + node.name());  
       for (int i = 1; i < node.count(); i++) {  
           printNode(node.child(i),"    "+inset);  
       }  
   }  
 
 
   public static void main(String[] args) {  
 
       QC6 v5 = new QC6();  
 
       v5.doInit("https://qm-center.10.1.1.1/qcbin", "CLOUDSERVICES",  
               "Cloud", "user", "pwd");  
       //Read from TestPlan  
      // v5.TP_testPlanRead2(TP_Pfad);  
 
       v5.disConnect();  
       System.out.println("by ...\n");  
   }  
 
}