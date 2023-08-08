def call() {
    node {

        if (! env.TAG_NAME) {
            env.TAG_NAME = ""
        }

        common.codequality()
        common.codechecks()
        common.artifacts()




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


