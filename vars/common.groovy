def codequality() {
    stage ('code quality') {
        echo 'code quality'
        }
    }

def codechecks() {
    if ( BRANCH_NAME == "main" || tag ==~ ".*" ) {
        stage('Style checks') {
            echo 'style checks'
        }
        stage('Unit Tests') {
            echo 'Unit Tests'
        }

    }
}

def artifacts () {
    if ( TAG_NAME ==~ ".*" ) {
        stage('Prepare Artifacts') {
            echo 'Prepare Artifacts'
        }

        stage('Prepare Artifacts') {
            echo 'Prepare Artifacts'
        }

        stage('Publish Artifacts') {
            echo 'Publish Artifacts'
        }
    }
}