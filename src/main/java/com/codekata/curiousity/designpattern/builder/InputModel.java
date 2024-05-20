package com.codekata.curiousity.designpattern.builder;

public class InputModel {

    private final String templateTheme;
    private final String siteType;
    private final String logo;
    private final String socials;
    private final String corporateColor;
    private final String font;
    private final String banner;
    private final String category;
    private final String loginPhrase;
    private final String loginTemplate;
    private final String loginBackground;
    private final String privacyPolicy;
    private final String termsAndConditions;
    private final String moduleName;
    private final String modulePackage;
    private final String moduleTemplate;

    public String getTemplateTheme() {
        return templateTheme;
    }

    public String getSiteType() {
        return siteType;
    }

    public String getLogo() {
        return logo;
    }

    public String getCorporateColor() {
        return corporateColor;
    }

    public String getFont() {
        return font;
    }

    public String getBanner() {
        return banner;
    }

    public String getCategory() {
        return category;
    }

    public String getLoginPhrase() {
        return loginPhrase;
    }

    public String getLoginTemplate() {
        return loginTemplate;
    }

    public String getLoginBackground() {
        return loginBackground;
    }

    public String getPrivacyPolicy() {
        return privacyPolicy;
    }

    public String getTermsAndConditions() {
        return termsAndConditions;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getModulePackage() {
        return modulePackage;
    }

    public String getModuleTemplate() {
        return moduleTemplate;
    }

    public String getSocials() {
        return socials;
    }


    public InputModel(InputBuilder builder) {
        this.templateTheme = builder.templateTheme;
        this.siteType = builder.siteType;
        this.logo = builder.logo;
        this.socials = builder.socials;
        this.corporateColor = builder.corporateColor;
        this.font = builder.font;
        this.banner = builder.banner;
        this.category = builder.category;
        this.loginPhrase = builder.loginPhrase;
        this.loginTemplate = builder.loginTemplate;
        this.loginBackground = builder.loginBackground;
        this.privacyPolicy = builder.privacyPolicy;
        this.termsAndConditions = builder.termsAndConditions;
        this.moduleName = builder.moduleName;
        this.modulePackage = builder.modulePackage;
        this.moduleTemplate = builder.moduleTemplate;
    }

    public static class InputBuilder {

        private String templateTheme;
        private String siteType;
        private String logo;
        private String socials;
        private String corporateColor;
        private String font;
        private String banner;
        private String category;
        private String loginPhrase;
        private String loginTemplate;
        private String loginBackground;
        private String privacyPolicy;
        private String termsAndConditions;
        private String moduleName;
        private String modulePackage;
        private String moduleTemplate;

        public InputBuilder() {
        }

        public InputBuilder templateTheme(String templateTheme) {
            this.templateTheme = templateTheme;
            return this;
        }

        public InputBuilder siteType(String siteType) {
            this.siteType = siteType;
            return this;
        }

        public InputBuilder logo(String logo) {
            this.logo = logo;
            return this;
        }

        public InputBuilder socials(String socials) {
            this.socials = socials;
            return this;
        }

        public InputBuilder corporateColor(String corporateColor) {
            this.corporateColor = corporateColor;
            return this;
        }

        public InputBuilder font(String font) {
            this.font = font;
            return this;
        }

        public InputBuilder banner(String banner) {
            this.banner = banner;
            return this;
        }

        public InputBuilder category(String category) {
            this.category = category;
            return this;
        }

        public InputBuilder loginPhrase(String loginPhrase) {
            this.loginPhrase = loginPhrase;
            return this;
        }

        public InputBuilder loginTemplate(String loginTemplate) {
            this.loginTemplate = loginTemplate;
            return this;
        }

        public InputBuilder loginBackground(String loginBackground) {
            this.loginBackground = loginBackground;
            return this;
        }

        public InputBuilder privacyPolicy(String privacyPolicy) {
            this.privacyPolicy = privacyPolicy;
            return this;
        }

        public InputBuilder termsAndConditions(String termsAndConditions) {
            this.termsAndConditions = termsAndConditions;
            return this;
        }

        public InputBuilder moduleName(String moduleName) {
            this.moduleName = moduleName;
            return this;
        }

        public InputBuilder modulePackage(String modulePackage) {
            this.modulePackage = modulePackage;
            return this;
        }

        public InputBuilder moduleTemplate(String moduleTemplate) {
            this.moduleTemplate = moduleTemplate;
            return this;
        }

        public InputModel build() {
            return new InputModel(this);
        }


    }
}
