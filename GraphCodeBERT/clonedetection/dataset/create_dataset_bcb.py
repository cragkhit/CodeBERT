import os
import json

def read_file_content(file_path):
    with open(file_path, 'r') as file:
        content = file.read()
    return content

def extract_file_name(file_path):
    path = file_path.split('/')[-1]
    # check whether the path variable contains a given substring
    if 'selected_' in path:
        path = path.replace('selected_', '').split('.java')[0]
    elif 'default_' in path:
        path = path.replace('default_', '').split('.java')[0]
    return path

def read_files_from_folder(folder_path):
    count = 1
    all_code_files = []
    for root, dirs, files in os.walk(folder_path):
        print(root)
        for file in files:
            file_path = os.path.join(root, file)
            if os.path.isfile(file_path) and file_path.endswith('.java'):
                # print(path)
                all_code_files.append([extract_file_name(file_path), read_file_content(file_path)])
                count+=1
    return all_code_files

def write_to_jsonl(file_path, data):
    with open(file_path, 'w') as f:
        for item in data:
            f.write(json.dumps({'func': item[1], 'idx': item[0]}))
            f.write('\n')
            # f.write('{"func": "    ' + item[1].replace('\n','\\n').replace('"','\\"').replace('$','\\$"') + '", "idx": "' + str(item[0]) + '"}\n')
            # f.write('{"func": "    ' + 'public static void main(String[] args) { System.out.println(\\"Hello World\\"); }' + '", "idx": "' + str(item[0]) + '"}\n')
    # with open(file_path) as f:
    #     for line in f:
    #         print(line)

def write_bcbharmful_groundtruth(input_file_path, output_file_path):
    with open(output_file_path, 'w') as fout:
        with open(input_file_path, 'r') as fin:
                lines = fin.readlines()
                for line in lines:
                    pair_info = line.split(',')
                    output = ''
                    if pair_info[0] == 'T':
                        output = extract_file_name(pair_info[1]) + '\t' + extract_file_name(pair_info[2]) + '\t1'
                    elif pair_info[0] == 'F':  
                        output = extract_file_name(pair_info[1]) + '\t' + extract_file_name(pair_info[2]) + '\t0'
                    fout.write(output + '\n')
        

# Main execution
project_path = '/Users/chaiyong/Downloads/do_not_delete/SimilBench/'
folder_path = 'data/bcbharmfulF'
code_files_list = read_files_from_folder(project_path + '/' + folder_path)
write_to_jsonl(project_path + '/bcbharmful.jsonl', code_files_list)
write_bcbharmful_groundtruth(project_path + '/truth/bcbharmful.csv', project_path + 'bcbharmful.txt')