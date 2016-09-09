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


    //����һ��focus�¼�
    $('[data-toggle="tab"],[data-toggle="pill"]').bind("focus", clickHandler);
    $('[data-toggle="tab"],[data-toggle="pill"]').bind("mouseenter", clickHandler);


    //����tab�Զ���ת������
    //1��ÿһ���ı��⣬����href/data-target
    //2��0��length-1���������һ��tabeleselector������i+1�ı���
    //3��ÿһ�������ݣ���shift+tab������
    //4��i+1�ı���shift+tab��i���������һ��tabeleselector
    var tabeleselector = "a:visible,button:visible,input:visible,textarea:visible,select:visible"; //tab���л���Ԫ�أ����ܲ�ȫ
    var tabtargetI = 0; //���ظ�����

    //����֮ǰ���Ȱ�����Ŀ�����ݶ���ʾ����
    $("[data-toggle]").each(function () {
        var $this = $(this);
        var $target = getTarget($this);
        $target.css("display", "block");
    });
    //���ù���
    $("[data-toggle]").each(function () {
        var $this = $(this);
        var $target = getTarget($this); //��ʾ���صĶ���
        bindTabTarget($this, $target.find(tabeleselector).first()); //�������1
        bindReTabTarget($target.find(tabeleselector).first(), $this); //�������3

        if (typeof ($this.attr("tabtarget")) == "undefined") {//����ĵ�һ��a��
            var $ul = $this.closest('ul:not(.dropdown-menu)');
            var $lis = $ul.find("li");
            if ($lis.length > 1) {
                //�������2
                for (var i = 0; i < $lis.length - 1; i++) {
                    var _target = getTarget($lis.eq(i).find("a,input,button"));
                    bindTabTarget(_target.find(tabeleselector).last(), $lis.eq(i + 1).find("a,input,button"));
                }
                //�������4
                for (var i = 1; i < $lis.length; i++) {
                    var $targetA = $lis.eq(i - 1).find("a,input,button");
                    var _target = getTarget($targetA);
                    bindReTabTarget($lis.eq(i).find("a,input,button"), _target.find(tabeleselector).last(), $targetA);
                }
            }
        }
    });
    //ȥ��display
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

    //��tab�¼�
    $("[totabtarget],[toretabtarget]").bind("keydown", function (e) {
        var e = window.event ? window.event : e;
        var keyCode = e.which ? e.which : e.keyCode;
        var $focus = null;
        if (keyCode == 9) {
            if (!e.shiftKey)//����shift
                $focus = $("[tabtarget='" + $(this).attr("totabtarget") + "']");
            else {//����shift
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
    //����tab�Զ���ת end




} (jQuery);
