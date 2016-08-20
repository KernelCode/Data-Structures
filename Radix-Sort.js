/*
  ماهي خوارزمية  Radix Sort ؟

هي خورزميه تم اختراعها من قبل : Herman Hollerith لاتعتمد على مقارنه القيم وترتب الارقام بالاعتماد على
مفاتيح للارقام الصحيحه من 0 الى 9 بالاعتماد على القيمه القصوى للرقم  least significant digit (LSD) وهي تعتبر من اسرع الخوارزمات الموجوده .

مصدر : http://bigocheatsheet.com/ 
معلومات اكثر : https://en.wikipedia.org/wiki/Radix_sort

الخوارزميه تم تنفيذها في لغة javascript  .

*/
  (function(){
  
      // mv - the maximum possible position of number in the array
      // ua - unsorted array
      
      function RadixSort(mv,ua){

          // part of the algorithm to get the position of the 
          var n = 1;

          // a 0 to 9 linked list queues FIFO
          var ll = Array(10);

          for(var i = 0; i < ll.length; i++ ){
              ll[i] = [];
          }

          // keep multiplying m and n until we sort the array!
          for( var m=10; m < mv; m *= 10, n *= 10 ){

              // push the number in array to our queue
              for( var i = 0; i < ua.length; i++ ){

                  ll[ Math.floor( (ua[i] % m) / n) ].push( ua[i] );
              }

              // replace the arry with new values 
              var uai=0;

              for(var i=0;i<ll.length;i++){

                  var cl = ll[i];

                  while(cl.length>0){

                      var v = cl.shift();
                      ua[uai] = v;
                      uai++;

                  }
              }

          }
          // return the new sorted array 
          return ua;
      }

      //create Random Array 
      function getRandomInt(min, max) {
          return Math.floor(Math.random() * (max - min + 1)) + min;
      }
      var ary=[];
      var max = 10000;
      var len = 700000;
      for(var i = 0 ;i<len;i++){
          ary.push(getRandomInt(10,max));
      }

      //Test Radix Sort 
      var start = new Date().getTime();

      RadixSort(max*10,ary);
      
      var end = new Date().getTime();
      var time = end - start;
      console.log('Radix Sort Time : ');
      console.log('Array Length = '+ary.length+',Execution time: ' + time);


      //Test Default Javascript Native Sort
      
      var ary2=[];
      for(var i = 0 ;i<len;i++){
          ary2.push(getRandomInt(10,max));
      }

      var start = new Date().getTime();

      RadixSort(max*10,ary);
      
      var end = new Date().getTime();
      var time = end - start;
      ary.sort();
      console.log('Default Javascript Sort Time: ');
      console.log('Array Length = '+ary.length+',Execution time: ' + time);
      
  })();
