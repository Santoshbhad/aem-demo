; (function ($) {
    "use strict";
    $.fn.annualReview = function () {
        var $this = $(this),
            $dropdownToggle = $this.find('.dropdown-toggle'),
            $dropdownMenu = $this.find('.dropdown-menu');

        var flag = false;

        $('body').on({
            'touchend': function (e) {
                //console.log(e.target);
                if (e.target.id == "dropdown-toggle"){
                    return;
                }

                $dropdownMenu.hide();
            }
        });

        return this.each(function () {

            $dropdownToggle.on("click touchstart", function (e) {
                e.stopPropagation();
                if (!flag) {
                    flag = true;
                    setTimeout(function () { flag = false; }, 100);

                    $dropdownMenu.toggle();
                }

                return false
            });

            $dropdownMenu.on("mouseleave", function (e) {
                e.stopPropagation();
                $dropdownMenu.hide();
            });

            $.grep([
                $this.find('.intro-background-dropdown'),
                $this.find('.stable-alternative-dropdown'),
                $this.find('.letter-to-our-membership-dropdown'),
                $this.find('.Results-dropdown'),
                $this.find('.Transitions-navigation-dropdown'),
                $this.find('.Financial-Highlights-navigation-dropdown'),
                $this.find('.Leadership-navigation-dropdown'),
                $this.find('.office-navigation-dropdown'),
                $this.find('.mutual-operations-dropdown'),
                $this.find('.stability-enables-dropdown')
            ], function ($this) {

                $this.parent().on('click touchend', function (e) {
                    e.stopPropagation();
                    if (!flag) {
                        flag = true;
                        setTimeout(function () { flag = false; }, 100);

                        var id = this.getElementsByTagName('a')[0].className.replace("-dropdown", "");

                        $('html,body').animate({
                            scrollTop: $("#" + id).offset().top - 53 // add 53px for the sticky nav
                        }, 'fast');
                        $dropdownMenu.hide();
                    }

                    return false
                });
            });
        });
    }
})(jQuery);
