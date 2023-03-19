
(function ($) {
    var blogsPage = {

        $blogPage:null,
        $blogsForm: null,
        $recaptcha: null,

        init: function () {
            blogsPage.$blogPage = $('.blogs-page');

            console.log("Im in blogs-page");
            if(blogsPage.$blogPage.length > 0){
                blogsPage.$blogsForm =  blogsPage.$blogPage.find(".comment_form");
                blogsPage.controls();
            }
        },
        controls: function () {
            blogsPage.$blogPage.find(".comment_form").on("submit",function (event){
                    event.preventDefault();
                    blogsPage.addComment(event);
                }
            );

        },

        addComment:function (event){
            var token = $("meta[name='_csrf']").attr("content");
            var header = $("meta[name='_csrf_header']").attr("content");
            console.log(blogsPage.$blogsForm.find("textarea[name='text'").val() );
            $.ajaxPrefilter(function (options,originalOptions,jqxhr){
                jqxhr.setRequestHeader(header,token)
            });

            $.ajax({
                'url': blogsPage.$blogsForm.attr("action") ,
                data:{
                    'text':blogsPage.$blogsForm.find("textarea[name='text'").val(),
                    'blogID':blogsPage.$blogsForm.find("input[name='blogID'").val()
                },
                type:'POST',
                success:function (data){
                    console.log("OK");
                    var json = JSON.stringify(data);
                    blogsPage.$blogsForm.find(".alert-success").fadeIn("slow");

                },
                error:function (textStatus, errorThrown){
                    console.log("ERROR");
                    blogsPage.$blogsForm.find(".alert-danger").fadeIn("slow");
                }
            });
        }


    };

    comments.blogsPage = blogsPage;
})(jQuery);