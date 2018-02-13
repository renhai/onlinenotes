/**
 * Created by hai on 2/11/18.
 */

$(function () {
  autosize($('#main-textarea'));

  var originVal = $('#main-textarea').val();
  $('#main-textarea').focus().val('').val(originVal);

  var postNotes = function () {
    var id = $('#note_id').val();
    var notes = $('#main-textarea').val();
    showLoading();
    axios.post('/notes/' + id, {
      notes: notes
    }).then(function (response) {
      hideLoading();
    }).catch(function (error) {
      console.log(error.response);
      $.notify(error.response.data, {className: 'error', position:'bottom right'});
      hideLoading();
    });
  }

  $('#main-textarea').keyup(_.debounce(postNotes, 500));

  function showLoading() {
    $('#loading').removeClass('hidden');
  }

  function hideLoading() {
    $('#loading').addClass('hidden');
  }

});

