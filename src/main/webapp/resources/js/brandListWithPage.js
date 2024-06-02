console.log("Reply Module........");

var jsonService = (function () {
function getList(param, callback, error) {
    var page = param.page || 1;

    $.getJSON("/admin/brand/select/" + page + ".json",
        function(data) { 	
          if (callback) {
            //callback(data); // 댓글 목록만 가져오는 경우 
          
            callback(data.replyCnt, data.list); //댓글 숫자와 목록을 가져오는 경우 
          }
        }).fail(function(xhr, status, err) {
      if (error) {
        error();
      }
    });
  }

})();
