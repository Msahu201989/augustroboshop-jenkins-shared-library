def call() {
    node {

        common.codequality()
        if (branch == "main" || tag ==~ "*" ) {
            stage('style checks') {
                echo 'code Quality'
            }
        }
    }
}