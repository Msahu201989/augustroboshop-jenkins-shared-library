def call() {
    node {



        common.codequality()
        common.codechecks()
        common.artifacts()







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


