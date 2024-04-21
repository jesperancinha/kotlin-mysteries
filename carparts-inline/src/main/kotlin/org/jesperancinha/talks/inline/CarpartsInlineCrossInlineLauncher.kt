package org.jesperancinha.talks.inline

import org.jesperancinha.talks.inline.main as launchMainTest
object CarpartsInlineCrossInlineLauncher {

        @JvmStatic
        fun main(args: Array<String> = emptyArray()) {
            launchMainTest()
            SpecialShopLocalReturn.main()
            SpecialShopNonLocalReturn.main()
            ExtendedCarPartsExample.main()
        }
}