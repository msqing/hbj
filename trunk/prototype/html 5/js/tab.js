/* ========================================================================
 * Bootstrap: tab.js v3.3.5
 * http://getbootstrap.com/javascript/#tabs
 * ========================================================================
 * Copyright 2011-2015 Twitter, Inc.
 * Licensed under MIT (https://github.com/twbs/bootstrap/blob/master/LICENSE)
 * ======================================================================== */


+function ($) {
    'use strict';

    // TAB CLASS DEFINITION
    // ====================

    var Tab = function (element) {
        // jscs:disable requireDollarBeforejQueryAssignment
        this.element = $(element)
        // jscs:enable requireDollarBeforejQueryAssignment
    }

    Tab.VERSION = '3.3.5'

    Tab.TRANSITION_DURATION = 150

    Tab.prototype.show = function () {
        var $this = this.element;
        if ($this.parent('li').hasClass('active')) return
        var $ul = $this.closest('ul:not(.dropdown-menu)');
        var selector = $this.data('target');

        if (!selector) {
            selector = $this.attr('href')
            selector = selector && selector.replace(/.*(?=#[^\s]*$)/, '') // strip for ie7
        }


        var $previous = $ul.find('.active:last a')
        var hideEvent = $.Event('hide.bs.tab', {
            relatedTarget: $this[0]
        })
        var showEvent = $.Event('show.bs.tab', {
            relatedTarget: $previous[0]
        })

        $previous.trigger(hideEvent)
        $this.trigger(showEvent)

        if (showEvent.isDefaultPrevented() || hideEvent.isDefaultPrevented()) return

        var $target = $(selector)

        this.activate($this.closest('li'), $ul)
        this.activate($target, $target.parent(), function () {
            $previous.trigger({
                type: 'hidden.bs.tab',
                relatedTarget: $this[0]
            })
            $this.trigger({
                type: 'shown.bs.tab',
                relatedTarget: $previous[0]
            })
        })
    }

    Tab.prototype.activate = function (element, container, callback) {
        var $active = container.find('> .active')
        var transition = callback
      && $.support.transition
      && ($active.length && $active.hasClass('fade') || !!container.find('> .fade').length)

        function next() {
            $active
        .removeClass('active')
        .find('> .dropdown-menu > .active')
          .removeClass('active')
        .end()
        .find('[data-toggle="tab"]')
          .attr('aria-expanded', false)

            element
        .addClass('active')
        .find('[data-toggle="tab"]')
          .attr('aria-expanded', true)

            if (transition) {
                element[0].offsetWidth // reflow for transition
                element.addClass('in')
            } else {
                element.removeClass('fade')
            }

            if (element.parent('.dropdown-menu').length) {
                element
          .closest('li.dropdown')
            .addClass('active')
          .end()
          .find('[data-toggle="tab"]')
            .attr('aria-expanded', true)
            }

            callback && callback()
        }

        $active.length && transition ?
      $active
        .one('bsTransitionEnd', next)
        .emulateTransitionEnd(Tab.TRANSITION_DURATION) :
      next()

        $active.removeClass('in')
    }


    // TAB PLUGIN DEFINITION
    // =====================

    function Plugin(option) {
        return this.each(function () {
            var $this = $(this)
            var data = $this.data('bs.tab')

            if (!data) $this.data('bs.tab', (data = new Tab(this)))
            if (typeof option == 'string') data[option]()
        })
    }

    var old = $.fn.tab

    $.fn.tab = Plugin
    $.fn.tab.Constructor = Tab


    // TAB NO CONFLICT
    // ===============

    $.fn.tab.noConflict = function () {
        $.fn.tab = old
        return this
    }


    // TAB DATA-API
    // ============

    var clickHandler = function (e) {
        e.preventDefault()
        Plugin.call($(this), 'show')
    }

    $(document)
    .on('click.bs.tab.data-api', '[data-toggle="tab"]', clickHandler)
    .on('click.bs.tab.data-api', '[data-toggle="pill"]', clickHandler);


    //绑定了一下focus事件
    $('[data-toggle="tab"],[data-toggle="pill"]').bind("focus", clickHandler);
    $('[data-toggle="tab"],[data-toggle="pill"]').bind("mouseenter", clickHandler);


    //处理tab自动跳转，规则：
    //1，每一个的标题，跳向href/data-target
    //2，0到length-1的内容最后一项tabeleselector，跳向i+1的标题
    //3，每一个的内容，都shift+tab到标题
    //4，i+1的标题shift+tab到i的内容最后一项tabeleselector
    var tabeleselector = "a:visible,button:visible,input:visible,textarea:visible,select:visible"; //tab键切换的元素，可能不全
    var tabtargetI = 0; //不重复即可

    //规则之前，先把所有目标内容都显示出来
    $("[data-toggle]").each(function () {
        var $this = $(this);
        var $target = getTarget($this);
        $target.css("display", "block");
    });
    //设置规则
    $("[data-toggle]").each(function () {
        var $this = $(this);
        var $target = getTarget($this); //显示隐藏的对象
        bindTabTarget($this, $target.find(tabeleselector).first()); //处理规则1
        bindReTabTarget($target.find(tabeleselector).first(), $this); //处理规则3

        if (typeof ($this.attr("tabtarget")) == "undefined") {//该组的第一个a，
            var $ul = $this.closest('ul:not(.dropdown-menu)');
            var $lis = $ul.find("li");
            if ($lis.length > 1) {
                //处理规则2
                for (var i = 0; i < $lis.length - 1; i++) {
                    var _target = getTarget($lis.eq(i).find("a,input,button"));
                    bindTabTarget(_target.find(tabeleselector).last(), $lis.eq(i + 1).find("a,input,button"));
                }
                //处理规则4
                for (var i = 1; i < $lis.length; i++) {
                    var $targetA = $lis.eq(i - 1).find("a,input,button");
                    var _target = getTarget($targetA);
                    bindReTabTarget($lis.eq(i).find("a,input,button"), _target.find(tabeleselector).last(), $targetA);
                }
            }
        }
    });
    //去掉display
    $("[data-toggle]").each(function () {
        var $this = $(this);
        var $target = getTarget($this);
        $target.css("display", "");
    });

    function getTarget($this) {
        var selector = $this.data('target');
        if (!selector) {
            selector = $this.attr('href')
            selector = selector && selector.replace(/.*(?=#[^\s]*$)/, '') // strip for ie7
        }
        return $(selector);
    }
    function bindTabTarget($this, $target) {
        tabtargetI++;
        $this.attr("totabtarget", tabtargetI);
        $target.attr("tabtarget", tabtargetI);
    }
    function bindReTabTarget($this, $target, $targetA) {
        tabtargetI++;
        $this.attr("toretabtarget", tabtargetI);
        $target.attr("retabtarget", tabtargetI);
        if ($targetA)
            $targetA.attr("retargetA", tabtargetI);
    }

    //绑定tab事件
    $("[totabtarget],[toretabtarget]").bind("keydown", function (e) {
        var e = window.event ? window.event : e;
        var keyCode = e.which ? e.which : e.keyCode;
        var $focus = null;
        if (keyCode == 9) {
            if (!e.shiftKey)//不按shift
                $focus = $("[tabtarget='" + $(this).attr("totabtarget") + "']");
            else {//按了shift
                $focus = $("[retabtarget='" + $(this).attr("toretabtarget") + "']");
                if ($focus.length > 0) {
                    var _retargetA = $("[retargetA='" + $(this).attr("toretabtarget") + "']");
                    if (_retargetA.length > 0) {
                        event.preventDefault();
                        Plugin.call(_retargetA, 'show');
                    } 
                }
            }
            if ($focus.length > 0) {
                $focus[0].focus();
                return false;
            }
        }
    });
    //处理tab自动跳转 end




} (jQuery);
