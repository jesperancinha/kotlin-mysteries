package org.jesperancinha.talks.inline.call;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jesperancinha.talks.inline.nocall.CallEngineCrossInline;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

public final class StartTheEngineJava {

    public static void main(String[] var0) {
        String var2 = "This is the start of the loop.";
        System.out.println(var2);
        introduction(()-> callEngineCrossInline(new CallEngineCrossInline()));
        var2 = "This is the end of the loop.";
        System.out.println(var2);
        String var4 = "Engine started!";
        System.out.println(var4);
        Unit var3 = Unit.INSTANCE;
        System.out.println(var3);
    }

    public static Void callEngineCrossInline(@NotNull Function0<Void> startManually) {
        Intrinsics.checkNotNullParameter(startManually, "startManually");
        String var3 = "This is the start of the loop.";
        System.out.println(var3);
        introduction(startManually);
        var3 = "This is the end of the loop.";
        System.out.println(var3);
        String var4 = "Engine started!";
        System.out.println(var4);
        return null;
    }

    public static void introduction(@NotNull Function0<Void> intro) {
        Intrinsics.checkNotNullParameter(intro, "intro");
        LocalDateTime var1 = LocalDateTime.now();
        System.out.println(var1);
        intro.invoke();
    }
}
