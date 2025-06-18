plugins {
    alias(libs.plugins.android.fusedlibrary)
}

androidFusedLibrary {
    namespace = "com.example.fusedlibrary"
    minSdk = 24
}

dependencies {
    include("io.grpc:grpc-protobuf:1.73.0")
}
