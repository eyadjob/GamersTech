//request filter to pass authorization header for each request
// other types are request , response , request error , response error

app.factory('AuthInterceptor', [ function() {
    return {
        'request' : function(config) {

           config.headers = config.headers || {};
           // var encodedString = btoa("admin:password"); //called the btoa() function to get the Base64-encoded string from the user’s credentials.
            //config.headers.Authorization = 'Basic ' + encodedString;
            return config;

        }
    };
} ]);