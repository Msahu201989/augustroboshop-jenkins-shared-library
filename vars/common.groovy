def codequality() {
    stage ('code quality') {
//        sh '''
//      sonar-scanner -Dsonar.host.url=http://172.31.10.133:9000 -Dsonar.login=${sonarUser} -Dsonar.password=${sonarPass} -Dsonar.projectKey=${COMPONENT} -Dsonar.qualitygate.wait=true ${SONAR_EXTRA_OPTS}
//        echo OK
//      '''
        }
    }

def codechecks() {
    if ( env.BRANCH_NAME == "main" || tag ==~ ".*" ) {
        stage('Style checks') {
            echo 'style checks'
        }
        stage('Unit Tests') {
            echo 'Unit Tests'
        }

    }
}

def artifacts () {
    if ( env.TAG_NAME ==~ ".*" ) {
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