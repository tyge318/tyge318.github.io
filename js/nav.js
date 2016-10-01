$(function() {
	/*
    $('nav ul li > a:not(:only-child)').mouseover(function(e) {
      $(this).siblings('.nav-dropdown').slideDown('fast');
      $('.nav-dropdown').not($(this).siblings()).slideUp('fast');
      e.stopPropagation();
    });
	*/
	$('.dropdown').hover(
		function() {
	      	$(this).children('.nav-dropdown').slideDown('fast');
	    }, function () {
			$(this).children('.nav-dropdown').slideUp('fast');
		}
	);
	$('html').click(function() {
      $('.nav-dropdown').hide();
    });
	$('#nav-toggle').on('click', function() {
	  this.classList.toggle('active');
	});
	
	$('#nav-toggle').click(function() {
	    $('nav ul').toggle();
	});
});

