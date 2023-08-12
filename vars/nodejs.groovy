def call() {
    node {
        try {
        common.codecheckout()
        common.codequality()
        common.codechecks()
        common.artifacts()
    }  catch (Exception e) {
        mail bcc: '', body: "Build Failure ${RUN_TESTS_DISPLAY_URL}", cc: '', from: 'mukeshsahu20@gmail.com', replyTo: '', subject: 'BUILD FAILURE', to: 'mukeshsahu20@gmail.com'
    }

















//        if (! env.TAG_NAME) {
//            env.TAG_NAME = ""
//        }


//

//
//            stage ('Prepare Artifact') {
//                when { tag "*" }
//                steps {
//                    echo 'Prepare Artifact'
//                }
//            }
//
//            stage ('Publish Artifact') {
//                when { tag "*" }
//                steps {
//                    echo 'Publish Artifact'
//                }
//            }

    }
}


