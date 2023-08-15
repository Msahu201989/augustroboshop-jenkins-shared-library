def codecheckout() {
    stage('code checkout') {
        sh 'find . | sed 1d |xargs rm -rf'
        git branch: 'main', url: "https://github.com/Msahu201989/${COMPONENT}.git"
    }
}

def codequality() {
    stage ('code quality') {
//        withCredentials([usernamePassword(credentialsId: 'SONAR', passwordVariable: 'sonarPass', usernameVariable: 'sonarUser')]) {
//            sh '''
//        #sonar-scanner -Dsonar.host.url=http://172.31.10.133:9000 -Dsonar.login=${sonarUser} -Dsonar.password=${sonarPass} -Dsonar.projectKey=${COMPONENT} -Dsonar.qualitygate.wait=true ${SONAR_EXTRA_OPTS}
        echo "OK"
//      '''
        }
    }

def codechecks() {
    if ( env.BRANCH_NAME == "main" || env.TAG_NAME ==~ ".*" ) {
        stage('Style checks') {
            echo 'style checks'
        }
        stage('Unit Tests') {
            echo 'Unit Tests'
        }

    }
}

def artifacts () {
//    if (env.TAG_NAME ==~ ".*") {

        stage('Prepare Artifacts') {
            if (env.APPTYPE == "nodejs") {
                sh '''
          npm install 
         # zip -r ${COMPONENT}-${TAG_NAME}.zip node_modules server.js 
        '''
            }

            if (env.APPTYPE == "java") {
                sh ''' 
              mvn clean package  
//mvn clean is a Maven command that deletes all the generated files and resources from the previous build of your project         
              mv target/${COMPONENT}-1.0.jar ${COMPONENT}.jar
              zip -r ${COMPONENT}-${TAG_NAME}.zip ${COMPONENT}.jar
              '''
            }
            if (env.APPTYPE == "python") {
                sh '''
           zip -r ${COMPONENT}-${TAG_NAME}.zip *.py ${COMPONENT}.ini requirements.txt
             '''
            }
            if (env.APPTYPE == "nginx") {
                sh '''
            cd static
            zip -r ../${COMPONENT}-${TAG_NAME}.zip *
            '''
            }
        }

        stage('Build Docker Image') {
            sh '''
               docker build -t 332775960109.dkr.ecr.us-east-1.amazonaws.com/cart:latest .
               '''
        }

//        if (env.TAG_NAME ==~ ".*") {


            stage('Publish Docker Image') {
                sh '''
         aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 332775960109.dkr.ecr.us-east-1.amazonaws.com
          docker tag 332775960109.dkr.ecr.us-east-1.amazonaws.com/${COMPONENT}:latest 332775960109.dkr.ecr.us-east-1.amazonaws.com/${COMPONENT}:${TAG_NAME}
         ocker push 332775960109.dkr.ecr.us-east-1.amazonaws.com/${COMPONENT}:${TAG_NAME}
             '''
            }
        }

