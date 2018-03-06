number_of_query = int(input())
subject_names = []
unread_chapters = []

for i in range(number_of_query):
    query = input()
    if(query != "-1"):
        temporary_list = query.split(" ")
        unread_chapters.append(int(temporary_list[0]))
        subject_names.append(temporary_list[1])
    else:
        minimum = unread_chapters[0]
        position = 0 
        books_to_remove = 0
        output = ""

        for i in range(len(unread_chapters)):
            if (minimum >= unread_chapters[i]):
                minimum = unread_chapters[i]
                position = i

        last_index=len(unread_chapters)-1

        while (last_index != position):
            books_to_remove += int(unread_chapters.pop())
            subject_names.pop()
            last_index -= 1

        output += str(books_to_remove)+" "+subject_names[position]
        subject_names.pop(position)
        unread_chapters.pop(position)
        print(output)
        