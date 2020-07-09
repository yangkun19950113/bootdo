function openPageJump(judge,url,title) {
    var nav = $(window.parent.document).find('.J_menuTabs .page-tabs-content ');
    $(window.parent.document).find('.J_menuTabs .page-tabs-content ').find(".J_menuTab.active").removeClass("active");
    $(window.parent.document).find('.J_mainContent').find("iframe").css("display", "none");

    var hasFlag=false;
    var index=0;
    var tabs=$(window.parent.document).find('.J_menuTabs .page-tabs-content ').find(".J_menuTab");
    for(var i=0;i<tabs.length;i++){
        /*if(tabs.eq(i).attr("name")==judge){*/
        if(tabs.eq(i).attr("data-id")==url){
            hasFlag=true;
            index=i;
        }
    }
    if(hasFlag){
        tabs.eq(index).addClass("active");
        tabs.eq(index).attr("data-id",url);
        $(window.parent.document).find('.J_mainContent').find("iframe").eq(index).css("display", "inline");
        $(window.parent.document).find('.J_mainContent').find("iframe").eq(index).attr("data-id",url);
        $(window.parent.document).find('.J_mainContent').find("iframe").eq(index).click();
    }else{
        var iframe = '<iframe class="J_iframe" name="iframe10000" width="100%" height="100%" src="' + url + '" frameborder="0" data-id="' + url
            + '" seamless="" style="display: inline;"></iframe>';
        $(window.parent.document).find('.J_menuTabs .page-tabs-content ').append(
        ' <a href="javascript:;" class="J_menuTab active" data-id="'+url+'" name="'+judge+'">' + title + ' <i class="fa fa-times-circle"></i></a>');
        $(window.parent.document).find('.J_mainContent').append(iframe);
    }
}