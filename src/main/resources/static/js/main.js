/**
 * Created by hai on 2/11/18.
 */

$(function () {
  autosize($('#main-textarea'));

  var postNotes = function () {
    var id = $('#note_id').val();
    var notes = $('#main-textarea').val();
    axios.post('/notes/' + id, {
      notes: notes
    }).then(function (response) {
      $.notify('Saved', {className: 'success', position:'top right', autoHideDelay: 1000});
    }).catch(function (error) {
      console.log(error.response);
      $.notify(error.response.data, {className: 'error', position:'bottom right'});
    });
  }

  $('#main-textarea').keyup(_.debounce(postNotes, 1000));

});

