if __name__ == '__main__':
    script = '<header>\n'\
            '   <script>\n'\
            '       var pre = null, pre_color;\n'\
            '       var hilightElement = function(e) {\n'\
            '           var event = e || window.event;\n'\
            '           var target = e.target || e.srcElement;\n'\
            '           if (pre) {\n'\
            '               pre.style.color = pre_color;\n'\
            '           }\n'\
            '           pre = target;\n'\
            '           pre_color = target.style.color;\n'\
            '           target.style.color = "red";\n'\
            '       };\n'\
            '       if (document.addEventListener){\n'\
            '           document.addEventListener("click", hilightElement, false);\n'\
            '       } else if (document.attachEvent){\n'\
            '           document.attachEvent("onclick", hilightElement);\n'\
            '       }\n'\
            '   </script>\n'\
            '</header>'

    with open('sp500.txt') as sp500:
        tickers = sp500.readlines()

    with open('sp500.html', 'w') as f:
        f.write('<html>\n')
        f.write(script)

        for _ in tickers:
            __ = _.split(',')
            path = __[1].strip()
            ticket = __[0].strip()
            f.write(
                '<a id="{}" target="_blank" href="https://www.morningstar.com/stocks/{}/{}/quote">{}</a><br>\n'.format(
                    ticket, path, ticket, ticket.upper()))

        f.write('</html>\n')

    with open('non-sp500.txt') as non_sp500:
        tickers = non_sp500.readlines()

    with open('non-sp500.html', 'w') as f:
        f.write('<html>\n')
        f.write(script)

        for _ in tickers:
            __ = _.split(',')
            f.write('<a target="_blank" href="https://www.morningstar.com/stocks/{}/{}/quote">{}</a><br>\n'.format(
                __[1].strip(), __[0].strip(), __[0].strip().upper()))

        f.write('</html>\n')

    pass
