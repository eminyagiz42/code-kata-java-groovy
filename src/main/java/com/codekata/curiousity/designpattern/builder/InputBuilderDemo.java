package com.codekata.curiousity.designpattern.builder;

public class InputBuilderDemo {

    public static void main(String[] args) {

        //Builder pattern

        String templateTheme = "";
        String siteType = "";
        String logo = "";
        String corporateColor = "";
        String font = "";
        String banner = "";
        String category = "";
        String loginPhrase = "";
        String loginTemplate = "";
        String loginBackground = "";
        String privacyPolicy = "";
        String termsAndConditions = "";
        String moduleName = "";
        String modulePackage = "";
        String moduleTemplate = "";
        String socials = "42";

        InputModel inputModel = new InputModel.InputBuilder()
                .siteType(siteType)
                .templateTheme(templateTheme)
                .logo(logo)
                .socials(socials)
                .corporateColor(corporateColor)
                .font(font)
                .banner(banner)
                .category(category)
                .loginPhrase(loginPhrase)
                .loginTemplate(loginTemplate)
                .loginBackground(loginBackground)
                .privacyPolicy(privacyPolicy)
                .termsAndConditions(termsAndConditions)
                .moduleName(moduleName)
                .modulePackage(modulePackage)
                .moduleTemplate(moduleTemplate)
                .build();


        System.out.println(inputModel.getSocials() + " is investigating the builder pattern");
    }
}
