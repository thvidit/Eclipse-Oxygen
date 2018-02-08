package com.football.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        TestFunction.class,
        TestFunction2.class,
        TestFunction3.class
})

public class AllTests {

}
