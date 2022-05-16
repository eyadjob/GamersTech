app.controller('registerUserController', function($scope, $http, $location,
                                                  $route) {

 /*   fileToUpload: File = null;*/

    $scope.selectedFile = new Blob();
    $scope.retrievedImage = null;
    $scope.base64Data= null;
    $scope.retrieveResonse= null;
    $scope.message= '';
    $scope.imageName = null;

    $scope.submitUserForm = function() {
        $http({
            method : 'POST',
            url : 'http://localhost:8381/api/user/',
            data : $scope.user,
        }).then(function(response) {
            $location.path("/list-all-users");
            $route.reload();
        }, function(errResponse) {
            $scope.errorMessage = errResponse.data.errorMessage;
        });
    };

    $scope.resetForm = function() {
        $scope.user = null;
    };

    $scope.onFileChanged = function(event) {
        //Select File
        this.selectedFile = event.target.files[0];
    };

    //Gets called when the user clicks on submit to upload the image
    $scope.onUpload = function(){
        alert("aaaaaaaaaa");
        console.log(this.selectedFile);

        //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
        const uploadImageData = new FormData();
        uploadImageData.append('imageFile', this.selectedFile, this.selectedFile.name);

        //Make a call to the Spring Boot Application to save the image
       /* this.httpClient.post('http://localhost:8080/image/upload', uploadImageData, { observe: 'response' })
            .subscribe((response) => {
                    if (response.status === 200) {
                        this.message = 'Image uploaded successfully';
                    } else {
                        this.message = 'Image not uploaded successfully';
                    }
                }
            );*/
        $http({
            method : 'POST',
            url : 'http://localhost:8381/image/upload',
            data : $scope.user,
            headers: {'Accept': '​application/json', 'content-Type':'multipart/form-data'}
        }).then(function(response) {
            if (response.status === 200) {
                this.message = 'Image uploaded successfully';
            } else {
                this.message = 'Image not uploaded successfully';
            }
        }, function(errResponse) {
            $scope.errorMessage = errResponse.data.errorMessage;
        });
    };

    //Gets called when the user clicks on retieve image button to get the image from back end
    $scope.getImage= function() {
        //Make a call to Sprinf Boot to get the Image Bytes.
       /* this.httpClient.get('http://localhost:8080/image/get/' + this.imageName)
            .subscribe(
                res => {
                    this.retrieveResonse = res;
                    this.base64Data = this.retrieveResonse.picByte;
                    this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
                }
            );*/

        $http({
            method : 'POST',
            url : 'http://localhost:8080/image/get/' + this.imageName,
            data : $scope.user,
        }).then(function(response) {
            this.retrieveResonse = res;
            this.base64Data = this.retrieveResonse.picByte;
            this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
        }, function(errResponse) {
            $scope.errorMessage = errResponse.data.errorMessage;
        });
    }

   /* $scope.handleFileInput = function(files){
        this.fileToUpload = files.item(0);
    }*/
});



app.controller('listUserController', function($scope, $http, $location, $route) {
    $http({
        method : 'GET',
        url : 'http://localhost:8381/api/user/'
    }).then(function(response) {
        $scope.users = response.data;
    });

    $scope.editUser = function(userId) {
        $location.path("/update-user/" + userId);
    }

    $scope.deleteUser = function(userId) {
        $http({
            method : 'DELETE',
            url : 'http://localhost:8381/api/user/' + userId
        })
            .then(
                function(response) {
                    $location.path("/list-all-users");
                    $route.reload();
                });
    }
});



app.controller('usersDetailsController',function($scope, $http, $location, $routeParams, $route) {

    $scope.userId = $routeParams.id;

    $http({
        method : 'GET',
        url : 'http://localhost:8381/api/user/' + $scope.userId
    }).then(function(response) {
        $scope.user = response.data;
    });

    $scope.submitUserForm = function() {
        $http({
            method : 'PUT',
            url : 'http://localhost:8381/api/user/' + $scope.userId,
            data : $scope.user,
        })
            .then(
                function(response) {
                    $location.path("/list-all-users");
                    $route.reload();
                },
                function(errResponse) {
                    $scope.errorMessage = "Error while updating User - Error Message: '"
                        + errResponse.data.errorMessage;
                });
    }


});

/*

$scope: $scope is used to set up dynamic content for the UI elements that this controller is responsible for. The concept of $scope is important in AngularJS as it can be seen as the glue that allows the template, model, and controller to work together. AngularJS supports dependency injection by naming conventions. AngularJS uses this $scope to keep the model and view separate but in sync. Any changes made in the view are reflected in the model, and any changes made in the model are reflected in the view.

$http: The $http service is the core feature provided by AngularJS and is used to consume the REST service

*/


app.controller('homeController', function ($rootScope, $scope, $http, $location, $routeParams, $route) {
    if ($rootScope.authenticated) {
        $location.path("/");
        $scope.loginerror = false;
    } else {
        $location.path("/login");
        $scope.loginerror = true;
    }
});


//executed  when login page is loaded
app.controller('loginController', function ($rootScope, $scope,
                                            $http, $location, $route) {
    $scope.credentials = {};

    $scope.resetForm = function () {
        $scope.credentials = null;
    }
    //the authenticate() function (a local helper function) that loads a user resource from the back end,
   // application-wide flag called authenticated that you used in the index.html by using rootScope it also shared by different controllers
    var authenticate = function (credentials, callback) {
        var headers = $scope.credentials ? {
            authorization: "Basic "
                + btoa($scope.credentials.username + ":"
                    + $scope.credentials.password)
        } : {};
        // make get call to  /user
        $http.get('http://localhost:8381/user', {
            headers: headers
        }).then(function (response) {
            if (response.data.name) {
                $rootScope.authenticated = true;
            } else {
                $rootScope.authenticated = false;
            }
            callback && callback();
        }, function () {
            $rootScope.authenticated = false;
            callback && callback();
        });
    }

    //The local helper function authenticate() is called when the controller is loaded to see whether the user is actually already authenticated, and you need this function just to make a remote call because the actual authentication is done by the server.
    authenticate();


    $scope.loginUser = function () {
        authenticate($scope.credentials, function () {
            if ($rootScope.authenticated) {
                $location.path("/");
                $scope.loginerror = false;
            } else {
                $location.path("/login");
                $scope.loginerror = true;
            }
        });
    };
});


app.controller('logoutController', function ($rootScope, $scope,
                                             $http, $location, $route) {
    $http.post('logout', {}).finally(function () {
        $rootScope.authenticated = false;
        $location.path("/");
    });
});