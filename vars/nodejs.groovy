def call() {
    node {

        sh 'env'
        common.codequality()
        if (branch == "main" || tag ==~ "*" ) {
            stage('style checks') {
                echo 'code Quality'
            }
        }
    }
}