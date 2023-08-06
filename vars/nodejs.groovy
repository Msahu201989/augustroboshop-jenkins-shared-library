//def call() {
//    node {
//
//        sh 'env'
//        common.codequality()
//
//
////        if (branch == "main" || tag ==~ "*" ) {
////            stage('style checks') {
////                echo 'code Quality'
////            }
////        }
//  }
//}
//
//


def call() {

    node {
        try {
            common.codeCheckout()
            common.codeQuality()
            common.codeChecks()
            common.artifacts()
        } catch (Exception e) {
            mail bcc: '', body: "Build Failed ${RUN_DISPLAY_URL}", cc: '', from: 'raghuk.vit@gmail.com', replyTo: '', subject: 'BUILD FAILURE', to: 'raghuk.vit@gmail.com'
        }

    }

}