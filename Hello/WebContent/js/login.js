$(document).ready(function(){
	let a = 0;
   $('form').find('.btn').on('click',function(){
	   if(a == 1)  $("#sb").prop('type', 'submit');
	 if(a == 0) a= 1;
	 
	  
	   
      $(this).parent().css({
        'height' : '350px',
        'transform' : 'translateY(50px)'
      });
        $(this).siblings('.form-group').css({
          'top':'20%'
        });
        $(this).siblings('.links').css({
          'top':'65%'
        });
      });
    
  
  
  /*-------- focus in ---------*/
  $('.pwd').on('focusin',function(){
    $(this).siblings('.user').css({
      'z-index'   :'1',
      'background':'rgba(0,0,0,.1)',
    });
     $(this).css({
      'z-index' : '2',
      'background' : '#fff',
      });
  });
  
  
   $('.user').on('focusin',function(){
    $(this).siblings('.pwd').css({
      'z-index'   :'1',
      'background':'rgba(0,0,0,.1)'
    });
    $(this).css({
      'z-index' : '2',
      'background' : '#fff'
     });
  });
  
  /*----------- focus out ---------*/
  $('.pwd').on('focusout',function(){
    $(this).siblings('.user').css({
      'z-index'   :'1',
      'background':'rgba(0,0,0,.1)'
    });
    $(this).css({
      'z-index' : '2',
      'background' : '#fff'
    });
  });
  

  
   $('.user').on('focusout',function(){
    $(this).siblings('.pwd').css({
      'z-index'   :'1',
      'background':'rgba(0,0,0,.1)'
    });
    $(this).css({
      'z-index' : '2',
      'background' : '#fff'
     });
  });
})