import os
import json

def read_file_content(file_path):
    with open(file_path, 'r') as file:
        content = file.read()
    return content

def read_files_from_folder(folder_path):
    count = 1
    all_code_files = []
    for root, dirs, files in os.walk(folder_path):
        # print(root)
        for file in files:
            file_path = os.path.join(root, file)
            # print(file_path)
            if os.path.isfile(file_path) and file_path.endswith('.java'):
                print(file_path)
                all_code_files.append([count, read_file_content(file_path)])
                count+=1
    print(count-1)
    return all_code_files

def write_to_jsonl(file_path, data):
    with open(file_path, 'w') as f:
        for item in data:
            f.write(json.dumps({'func': item[1], 'idx': str(item[0])}))
            f.write('\n')
    # with open(file_path) as f:
    #     for line in f:
    #         print(line)

def write_ocd_groundtruht(file_path):
    with open(file_path, 'w') as f:
        for i in range(1, 9):
            for j in range(1, 9):
                if (i<=2 and j<=2) or (i>2 and i<=4 and j>2 and j<=4) or (i>4 and i<=6 and j>4 and j<=6) or (i>6 and i<=8 and j>6 and j<=8):
                    f.write(str(i) + '\t' + str(j) + '\t1\n')
                else:
                    f.write(str(i) + '\t' + str(j) + '\t0\n')
        

# Main execution
project_path = '/Users/chaiyong/Downloads/do_not_delete/SimilBench/data/'
folder_path = '/ocd8x8F/'
code_files_list = read_files_from_folder(project_path + '/' + folder_path)
write_to_jsonl(project_path + '/ocd8x8.jsonl', code_files_list)
write_ocd_groundtruht(project_path + '/ocd8x8_test.txt')