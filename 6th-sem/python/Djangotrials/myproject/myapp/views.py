from django.shortcuts import render
from django.http import HttpResponseRedirect
from myapp.models import myproject
from myapp.forms import myprojectForm

# Create your views here.
def index(request):
    #myproject1 = myproject.objects.all()
    form = myprojectForm()
    return render(request, 'index.html', {'form':form})

def post_resume(request):
    form = myprojectForm(request.POST)
    if form.is_valid():
        tr = myproject(
            name = form.cleaned_data['name'],
            regno = form.cleaned_data['regno'],
            cgpa = form.cleaned_data['cgpa'],
            email = form.cleaned_data['email'],
            location = form.cleaned_data['location'],
            img_url = form.cleaned_data['img_url']
        )
        tr.save()
    return HttpResponseRedirect('/show/')

def show(request):
    myproject1 = myproject.objects.all()
    return render(request , 'show.html',{'myprojecte':myproject1})