def call() {
    node {

        sh 'env'
        common.codequality()

        if ( BRANCH_NAME == "main" || tag ==~ "*" ) {
            stage('Style checks') {
                echo 'style checks'
            }
          }

//    pipeline {
//
//        agent {
//            node { label 'Workstation' }
//        }
//
//        stages {
//
//            common.codequality()
//

//
//            stage ('unit Tests') {
//                when {
//                    branch 'demo'
//                }
//                steps {
//                    echo 'Unit Test'
//                }
//            }
//
//            stage ('Download dependencies') {
//                when {
//                    branch 'demo'
//                }
//                steps {
//                    echo 'Download Dependencies'
//                }
//            }
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


