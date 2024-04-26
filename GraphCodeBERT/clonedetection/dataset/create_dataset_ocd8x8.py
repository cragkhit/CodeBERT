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
        print(root)
        for file in files:
            file_path = os.path.join(root, file)
            # print(file_path)
            if os.path.isfile(file_path) and file_path.endswith('.java'):
                print(file_path)
                all_code_files.append([count, read_file_content(file_path)])
                count+=1
    print(count)
    return all_code_files

def write_to_jsonl(file_path, data):
    with open(file_path, 'w') as f:
        for item in data:
            f.write(json.dumps({'func': item[1], 'idx': item[0]}))
            f.write('\n')
    # with open(file_path) as f:
    #     for line in f:
    #         print(line)

def write_ocd_groundtruht(file_path):
    with open(file_path, 'w') as f:
        for i in range(1, 101):
            for j in range(1, 101):
                if (i<=10 and j<=10) or (i>10 and i<=20 and j>10 and j<=20) or (i>20 and i<=30 and j>20 and j<=30) or (i>30 and i<=40 and j>30 and j<=40) or (i>40 and i<=50 and j>40 and j<=50) or (i>50 and i<=60 and j>50 and j<=60) or (i>60 and i<=70 and j>60 and j<=70) or (i>70 and i<=80 and j>70 and j<=80) or (i>80 and i<=90 and j>80 and j<=90) or (i>90 and i<=100 and j>90 and j<=100):
                    f.write(str(i) + '\t' + str(j) + '\t1\n')
                else:
                    f.write(str(i) + '\t' + str(j) + '\t0\n')
        

# Main execution
project_path = '/Users/chaiyong/Downloads/do_not_delete/CodeBERTChaiyong/GraphCodeBERT/clonedetection/dataset'
folder_path = '/ocd8x8/'
code_files_list = read_files_from_folder(project_path + '/' + folder_path)
write_to_jsonl(project_path + '/ocd8x8.jsonl', code_files_list)
write_ocd_groundtruht(project_path + '/ocd8x8_test.txt')