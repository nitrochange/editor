val table = longtable {
    caption {  }
    hline {  }
    headings {
        boldfont {  }
        boldfont {  }
        boldfont {  }
        boldfont {  }
    }
    hline {  }
    addcontinuelabel { newPage ->  false }
    hline {  }
    addlabeldublications {  }
    addcontinuelabel { newPage -> true }
    content {
        row {

        }
        row {

        }
        row {

        }
        row {

        }
    }
    repeatcontent {  }
}

print(table.toTex())