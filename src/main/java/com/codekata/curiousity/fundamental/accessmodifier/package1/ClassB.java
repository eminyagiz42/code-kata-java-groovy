package com.codekata.curiousity.fundamental.accessmodifier.package1;

import com.codekata.curiousity.fundamental.accessmodifier.package2.ChildClass;
import com.codekata.curiousity.fundamental.accessmodifier.package2.ClassAChild;
import com.codekata.curiousity.fundamental.accessmodifier.package2.ClassBChild;
import com.codekata.curiousity.fundamental.accessmodifier.package2.ParentClass;

/**
 * The type Class b.
 */
public class ClassB {

    /**
     * The Package 1 class b default.
     */
    int package1_ClassB_default = 0;
    /**
     * The Package 1 class b public.
     */
    public int package1_ClassB_public = 1;
    private int package1_ClassB_private = 2;
    /**
     * The Package 1 class b protected.
     */
    protected int package1_ClassB_protected = 3;

    /**
     * Learn access modifiers.
     */
    public void learnAccessModifiers() {

        withinClass(); // All of them accessible

        withinPackage(); // private not accessible

        outsidePackage(); // Only public is accessible

        outsidePackageButSubclass(); // public and subclass's protected are accessible

    }

    private static void outsidePackage() {
        System.out.println();

        ParentClass parentClass = new ParentClass();
        System.out.println("\nWe're calling variables in \"parentClass\" in the \"package2\""); // DIFFERENT CLASS, DIFFERENT PACKAGE
        System.out.println("default:" + " Cannot access"); //parentClass.package2_ParentClass_default
        System.out.println("public :" + parentClass.package2_ParentClass_public);
        System.out.println("private :" + " Cannot access"); //parentClass.package2_ParentClass_private
        System.out.println("protected :" + " Cannot access"); //parentClass.package2_ParentClass_protected

        System.out.println();

        ChildClass childClass = new ChildClass();
        System.out.println("\nWe're calling variables in \"childClass\" in the \"package2\""); // DIFFERENT CLASS, DIFFERENT PACKAGE
        System.out.println("default:" + " Cannot access"); //parentClass.package2_ParentClass_default
        System.out.println("public :" + childClass.package2_ChildClass_public);
        System.out.println("private :" + " Cannot access"); //parentClass.package2_ParentClass_private
        System.out.println("protected :" + " Cannot access"); //parentClass.package2_ParentClass_protected
        System.out.println("public :" + childClass.package2_ParentClass_public); //This comes from the parent class public
    }

    private static void outsidePackageButSubclass() {
        System.out.println();

        ClassBChild childB = new ClassBChild();
        System.out.println("\nWe're calling variables in \"ClassBChild\" in the \"package2\""); // DIFFERENT CLASS, DIFFERENT PACKAGE
        System.out.println("default :" + " Cannot access"); //childB.package2_ChildBClass_default);
        System.out.println("public :" + childB.package2_ClassBChild_public);
        System.out.println("private :" + " Cannot access"); //childB.package2_ChildBClass_private);
        System.out.println("protected :" + " Cannot access"); //childB.package2_ChildBClass_protected);

        System.out.println("default :" + " Cannot access"); //childB.package1_ClassB_default); INHERITANCE FROM CLASSB
        System.out.println("public :" + childB.package1_ClassB_public);
        System.out.println("private :" + " Cannot access"); //childB.package1_ClassB_private);
        System.out.println("protected :" + childB.package1_ClassB_protected);


        System.out.println();

        ClassAChild childA = new ClassAChild();
        System.out.println("\nWe're calling variables in \"ClassAChild\" in the \"package2\""); // DIFFERENT CLASS, DIFFERENT PACKAGE
        System.out.println("default :" + " Cannot access"); //childA.package2_childAClass_default);
        System.out.println("public :" + childA.package2_ClassAChild_public);
        System.out.println("private :" + " Cannot access"); //childA.package2_childAClass_private);
        System.out.println("protected :" + " Cannot access"); //childA.package2_childAClass_protected);

        System.out.println("default :" + " Cannot access"); //childA.package1_ClassA_default);  // INHERITANCE FROM CLASSA
        System.out.println("public :" + childA.package1_ClassA_public);
        System.out.println("private :" + " Cannot access"); //childA.package1_ClassA_private);
        System.out.println("protected :" + childA.package1_ClassA_protected);
    }

    private static void withinPackage() {
        System.out.println();

        ClassA classA = new ClassA();
        System.out.println("\nWe're calling variables in \"classA\" in the \"package1\""); // DIFFERENT CLASS SAME PACKAGE
        System.out.println("default :" + classA.package1_ClassA_default);
        System.out.println("public :" + classA.package1_ClassA_public);
        System.out.println("private :" + " Cannot access"); //classA.package1_ClassA_private
        System.out.println("protected :" + classA.package1_ClassA_protected);
    }

    private static void withinClass() {
        ClassB classB = new ClassB();
        System.out.println("This is \"classB\" in the\"package1\"");

        System.out.println("\nWe're calling variables in \"classB\" in the \"package1\""); // SAME CLASS
        System.out.println("default :" + classB.package1_ClassB_default);
        System.out.println("public :" + classB.package1_ClassB_public);
        System.out.println("private :" + classB.package1_ClassB_private);
        System.out.println("protected :" + classB.package1_ClassB_protected);
    }
}
