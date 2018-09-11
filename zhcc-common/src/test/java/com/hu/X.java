package com.hu;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * @author hulichao
 * @date 2018/8/30
 */

public class X
{
    public void calc(String expr)
    {
        ScriptEngineManager manager=new ScriptEngineManager();
        ScriptEngine engine =manager.getEngineByName("js");
        try
        {
            System.out.println(engine.eval(expr));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static void main(String args[])
    {
        //总共多少张发票 7+8+9+17+2+1+1+1=46   最近的一次8.30包含7张票
        String expr2018_8_30_7="25+20+25+28+15+15+25+15+15+25+15+18+15+20+25+15+28+15+25+15+25+15+15+14.78+15+22+25+15+22+15+15+18+15+22+21.85+15+22+18+15+22+15+14.9+15+15+19.84+14.9";
        new X().calc(expr2018_8_30_7);
        //总共2+8+2 =10 最近一次9.10包含2张票
        String expr2018_9_10_2 = "25+15+20+15+28";
    }
}
