package com.yonyou.statemachine;
/**
 * Information about a state.
 * and InstructionSet Info in the state machine
 */
public class StateInstructionSetInfo {
    public String classname ;
    public String state  ;



    public  StateInstructionSetInfo(String classname,String state){
        this.classname =classname;
        this.state= state;
    }

    @Override
    public String toString() {
        return "state=" + this.state + ",classname=" + this.classname ;
    }
}
