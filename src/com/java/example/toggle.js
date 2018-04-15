             function change()
                   {
                       var i;
                       var input = document.getElementById("string").value;
                       var b = "";
                       for (i = 0; i < input.length; i++)
                        {
                           if (input.charCodeAt(i) >= 65 && input.charCodeAt(i) <= 90)
                           {
                               b = b + input.charAt(i).toLowerCase();
                           }
                           else
                           {
                               b = b + input.charAt(i).toUpperCase();

                           }

                        }
                         document.getElementById("result").innerHTML = "Toggled String is "+b;
                   }
