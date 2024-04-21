package org.jesperancinha.talks.inline.nocall;

import kotlin.jvm.functions.Function0;

public class CallEngineCrossInline implements Function0<Void> {

    public final Void invoke() {
        String var1 = "Get computer in the backseat";
        System.out.println(var1);
        return null;
    }
}
