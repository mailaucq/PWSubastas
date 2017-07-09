package com.subastas.web;

import junit.framework.Test;
import junit.framework.TestSuite;

public class TestSuit {

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTestSuite(RegistroTest.class);
    suite.addTestSuite(LoginTest.class);
    suite.addTestSuite(BuscarProductoTest.class);
    suite.addTestSuite(ProductoTest.class);
    suite.addTestSuite(PerfildeUsuarioTest.class);
    suite.addTestSuite(ComprarMonedasTest.class);
    suite.addTestSuite(GoAgregarProductoTest.class);
    suite.addTestSuite(UploadImageTest.class);
    suite.addTestSuite(AddProductoTest.class);
    suite.addTestSuite(GoContactanosTest.class);
    suite.addTestSuite(AddConsultaTest.class);
    suite.addTestSuite(MonitorTest.class);
    return suite;
  }

  public static void main(String[] args) {
    junit.textui.TestRunner.run(suite());
  }
}
