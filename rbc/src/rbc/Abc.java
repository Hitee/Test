package rbc;

import java.io.IOException;

public class Abc {
public static void main(String[] args) {
	// This is a fairly important section for x64 bit machines,
    // as a note this took me forever to figure out. Basically,
    // if the DLL is not registered in the SysWOW64 dir then we
    // are unable to use this as it was created when 32-bit
    // computers were still all the rage. This is a quick little
    // hack that registers it if it is needed to be registered.
    // If it's already registered, this does nothing.
	System.out.println("hi");
    try {
        Runtime.getRuntime()
                .exec("C:\\windows\\SysWOW64\\regsvr32 /s lib\\OTAClient.dll")
                .waitFor();
        Runtime.getRuntime()
                .exec("C:\\windows\\SysWOW64\\regsvr32 /s lib\\com4j-amd64.dll")
                .waitFor();
        Runtime.getRuntime()
                .exec("C:\\windows\\SysWOW64\\regsvr32 /s lib\\com4j-x86.dll")
                .waitFor();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
       /* Utilities.showError(
                        new JFrame(),
                        "OTAClient.dll, com4j-amd64.dll or com4j-x86.dll could not "
                                + "be registered, program may or may not work on a 64-bit machine "
                                + "without these files. You can attempt to manually register them, "
                                + "but this rarely works.");*/
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
}
