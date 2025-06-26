import com.android.build.api.attributes.BuildTypeAttr

plugins {
    alias(libs.plugins.android.fusedlibrary)
}

androidFusedLibrary {
    namespace = "com.example.fusedlibrary"
    minSdk = 24
}

dependencies {
    include(project(":mylibrary"))
}

// Temporary workaround for b/425861331, remove when issue is fixed.
configurations.configureEach {
    attributes {
        // This attribute can be removed from AGP 8.12-alpha07.
        attribute(
            BuildTypeAttr.ATTRIBUTE,
            project.objects.named(BuildTypeAttr::class.java, "release"),
        )
        attribute(
            TargetJvmEnvironment.TARGET_JVM_ENVIRONMENT_ATTRIBUTE,
            project.objects.named(TargetJvmEnvironment::class.java, TargetJvmEnvironment.ANDROID)
        )
    }
}