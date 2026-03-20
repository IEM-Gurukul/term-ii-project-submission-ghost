package monitor;

import strategy.ReleaseCondition;
import model.Vault;

public class VaultMonitor extends Thread {

    private Vault vault;
    private ReleaseCondition condition;

    public VaultMonitor(Vault vault,ReleaseCondition condition){
        this.vault=vault;
        this.condition=condition;
    }

    public void run(){

        while(true){

            if(condition.shouldRelease(vault)){

                System.out.println("Vault released to nominee");

                break;
            }

            try{
                Thread.sleep(5000);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}