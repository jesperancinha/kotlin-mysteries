package org.jesperancinha.talks.inline.nocall;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

public final class StartTheEngineJava {

    public static void main(String[] var0) {
        String var2 = "This is the start of the loop.";
        System.out.println(var2);
        introduction(new CallEngineCrossInline());
        var2 = "This is the end of the loop.";
        System.out.println(var2);
        String var4 = "Engine started!";
        System.out.println(var4);
        Unit var3 = Unit.INSTANCE;
        System.out.println(var3);
    }

    public static void callEngineCrossInline(@NotNull Function0 startManually) {
        Intrinsics.checkNotNullParameter(startManually, "startManually");
        String var3 = "This is the start of the loop.";
        System.out.println(var3);
        introduction(new CallEngineCrossInline());
        var3 = "This is the end of the loop.";
        System.out.println(var3);
        String var4 = "Engine started!";
        System.out.println(var4);
    }

    public static void introduction(@NotNull Function0 intro) {
        Intrinsics.checkNotNullParameter(intro, "intro");
        LocalDateTime var1 = LocalDateTime.now();
        System.out.println(var1);
        intro.invoke();
    }
}
