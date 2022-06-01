(function () {
    var profilePage = {

        $profilePage:null,
        $blogsForm: null,
        $recaptcha: null,

        init: function () {
            profilePage.$profilePage = $('.profilePage');
            console.log("testing");
            if(profilePage.$profilePage.length > 0){
                profilePage.controls();
            }
        },
        controls: function () {
            console.log("profile page ...")
            let selectedTab = gamersFun.profilePage.getParameterByName("tab");
            console.log("selected tab ..." + selectedTab)
            if(gamersFun.profilePage.$profilePage.find("#" + selectedTab + "-tab").length > 0){
                gamersFun.profilePage.$profilePage.find("#" + selectedTab+ "-tab").trigger('click')
            }else{
                if(gamersFun.profilePage.$profilePage.find("input[name='addBlogtab']").length > 0){
                    let addTabSelector = gamersFun.profilePage.$profilePage.find("input[name='addBlogtab']").val();
                    gamersFun.profilePage.$profilePage.find("#" + addTabSelector + "-tab").trigger('click')
                }
            }

            profilePage.$profilePage.find('.delete-blog').on("click",this.deleteBlog);

            $("#blogTaging").tagit({
                caseSensitive: false,
                allowSpaces: true,
                tagLimit: 10,
                readOnly: $("#add-blogs").find("input[name='ownProfile']").val(),
                /*availableTags: ["music","reading","swiming"]*/
                afterTagRemoved: function (event,ui){
                    profilePage.deleteBlog(event,ui.tagLabel);
                    console.log("tag removed ...")
                },
                afterTagAdded: function (event,ui){
                    if(ui.duringInitialization != true){
                        profilePage.saveTag(event,ui.tagLabel);
                        console.log("tag added ...")
                    }

                }
            });

        },

         getParameterByName: function(name) {
            name = name.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
            var regex = new RegExp("[\\?&]" + name + "=([^&#]*)")
                , results = regex.exec(location.search);
            return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
        },
        deleteBlog: function(){
            if (confirm('Are you sure you want to delete this blog from the database?')) {
                // Delete it!
                console.log("Delete action " + $(this).attr("href"));
                $.ajax({
                    url:$(this).attr("action"),
                    type:"GET",
                    success:function(data){
                       gamersFun.profilePage.$profilePage.find(".delete-alert-success").fadeOut();
                    },
                    error: function (textStatus, errorThrown) {
                        gamersFun.profilePage.$profilePage.find(".delete-alert-error").fadeOut();

                    }
                });
                // return true;
            } else {
                //  return false;
            }

        },
        showSuccessDeleteBlog: function(data){
            profilePage.$profilePage.append(data.message);
            window.setTimeout(function(){
                profilePage.$profilePage.text('');
            },2000)
        },

        saveTag:function (event,text){
            console.log("save Interest url : ");
            profilePage.editTag(text,profilePage.$profilePage.find("input[name='saveInterest']").val());

        },
        deleteTag:function (event,text){
            console.log("delete Interest url : ");
            profilePage.editTag(text,profilePage.$profilePage.find("input[name='deleteInterest']").val());

        },
        editTag:function (text,actionUrl){
            var token = $("meta[name='_csrf']").attr("content");
            var header = $("meta[name='_csrf_header']").attr("content");

            $.ajaxPrefilter(function (options,originalOptions,jqxhr){
                jqxhr.setRequestHeader(header,token)
            });

            $.ajax({
                'url': actionUrl,
                data:{
                    'name':text
                },
                type:'POST',
                success:function (data){
                    console.log("OK");
                },
                error:function (textStatus, errorThrown){
                    console.log("ERROR");
                }
            });
        }


    };

    gamersFun.profilePage = profilePage;
})();